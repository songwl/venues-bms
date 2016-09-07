package com.venues.bms.service.impl.page;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Constant;
import com.venues.bms.core.model.Page;
import com.venues.bms.core.utils.FreemarkerUtils;
import com.venues.bms.core.utils.HtmlUtils;
import com.venues.bms.core.utils.ResourceUtils;
import com.venues.bms.dao.MoModuleAttributeMapper;
import com.venues.bms.dao.MoModuleMapper;
import com.venues.bms.dao.PgPageContentMapper;
import com.venues.bms.dao.PgPageMapper;
import com.venues.bms.dao.PgPageModuleAttributeMapper;
import com.venues.bms.dao.TmpTemplateMapper;
import com.venues.bms.po.MoModule;
import com.venues.bms.po.MoModuleAttribute;
import com.venues.bms.po.PgPage;
import com.venues.bms.po.PgPageContent;
import com.venues.bms.po.PgPageModuleAttribute;
import com.venues.bms.po.TmpTemplate;
import com.venues.bms.po.VeVenue;
import com.venues.bms.po.VeVenueAttr;
import com.venues.bms.service.page.PageService;
import com.venues.bms.vo.GenPage;
import com.venues.bms.vo.GenPageModule;

@Service
public class PageServiceImpl implements PageService {

	@Autowired
	private PgPageMapper pgPageMapper;

	@Autowired
	private PgPageContentMapper pgPageContentMapper;

	@Autowired
	private PgPageModuleAttributeMapper pgPageModuleAttributeMapper;

	@Autowired
	private TmpTemplateMapper tmpTemplateMapper;

	@Autowired
	private MoModuleMapper moModuleMapper;
	
	@Autowired
	private MoModuleAttributeMapper moModuleAttributeeMapper;

	@Override
	public Page<PgPage> findPgPages(Page<PgPage> page, Map<String, Object> params) {

		int count = pgPageMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<PgPage> list = findPageList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<PgPage> findPageList(Map<String, Object> params) {
		return pgPageMapper.selectByParams(params);
	}

	@Override
	public int updatePageStatus(int id, Integer code) {
		// TODO Auto-generated method stub
		PgPage page = new PgPage();
		page.setId(id);
		page.setPageState(code);
		return pgPageMapper.updateByPrimaryKeySelective(page);
	}

	@Override
	public int updatePublishByVenueIds(String ids) {
		pgPageMapper.updateAllPublishOff();
		return pgPageMapper.updatePublishByVenueIds(ids);
	}

	@Override
	public int updatePublish(String ids) {
		return pgPageMapper.updatePublishByIds(ids);
	}

	@Override
	public PgPage getPgPageById(int id) {
		return pgPageMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(PgPage page) {
		return pgPageMapper.updateByPrimaryKey(page);
	}

	@Override
	public int deletePage(Integer id) {
		return pgPageMapper.deleteByPrimaryKey(id);
	}

	@Override
	public GenPage getPageDetail(int id) {
		PgPage page = pgPageMapper.selectByPrimaryKey(id);
		TmpTemplate template = tmpTemplateMapper.selectByPrimaryKey(page.getTemplateID());

		GenPage gen = new GenPage();
		gen.setPageId(page.getId());
		gen.setPageName(page.getPageName());
		gen.setPageDescription(page.getPageDescription());
		gen.setLikeCount(page.getLikeCount());
		gen.setBodyWidth(template.getTemplateWidth());
		gen.setBodyHeight(template.getTemplateHeight());
		gen.setBackgroundColor(HtmlUtils.parseToRGB(template.getTemplateColor()));
		gen.setBackgroundImage(template.getTemplateImage());

		List<GenPageModule> modules = new ArrayList<>();
		List<MoModule> moduleList = moModuleMapper.selectByTemplateId(template.getId());
		for (MoModule module : moduleList) {
			GenPageModule gpm = new GenPageModule();
			gpm.setModuleId(module.getID());
			gpm.setModuleType(module.getModuleType() == 32 ? "TEXT" : (module.getModuleType() == 33 ? "IMAGE" : "VIDEO"));
			gpm.setLeft(module.getModuleX());
			gpm.setTop(module.getModuleY());
			gpm.setWidth(module.getModuleWidth());
			gpm.setHeight(module.getModuleHeight());
			gpm.setBackgroundImage(module.getModuleImage());
			gpm.setzIndex(module.getModuleDepth());

			Map<String, Object> param = new HashMap<>();
			param.put("pageID", page.getId());
			param.put("moduleID", module.getID());
			List<PgPageContent> pageContentList = pgPageContentMapper.selectByPageIdAndModuleId(param);
			if (CollectionUtils.isNotEmpty(pageContentList)) {
				if (module.getModuleType() == 32) { //TEXT
					gpm.setContent(HtmlUtils.parseHtml(pageContentList.get(0).getContentValue()));
				} else if (module.getModuleType() == 34) { //VIDEO
					gpm.setVideoUrl(pageContentList.get(0).getContentValue());
				} else {
					List<String> imageUrls = new ArrayList<>();
					for (PgPageContent pageContent : pageContentList) {
						imageUrls.add(pageContent.getContentValue());
					}
					gpm.setImageUrls(imageUrls);
				}
			}
			List<PgPageModuleAttribute> maList = pgPageModuleAttributeMapper.selectByPageIdAndModuleId(param);
			if (CollectionUtils.isNotEmpty(maList)) {
				for (PgPageModuleAttribute ma : maList) {
					if(StringUtils.isBlank(ma.getMAValue())){
						continue;
					}
					if (ma.getMAKey() == 44) {
						gpm.setZoomMode(ma.getMAValue());
					} else if (ma.getMAKey() == 45) {
						gpm.setFontFamily(ma.getMAValue());
					} else if (ma.getMAKey() == 46) {
						gpm.setFontSize(ma.getMAValue());
					} else if (ma.getMAKey() == 47) {
						gpm.setFontWeight(ma.getMAValue());
					} else if (ma.getMAKey() == 48) {
						gpm.setFontStyle(ma.getMAValue());
					} else if (ma.getMAKey() == 49) {
						gpm.setTextDecoration(ma.getMAValue());
					} else if (ma.getMAKey() == 50) {
						gpm.setColor(HtmlUtils.parseToRGB(Integer.valueOf(ma.getMAValue())));
					} else if (ma.getMAKey() == 52) {
						gpm.setOpacity(ma.getMAValue());
					} else if (ma.getMAKey() == 53) {
						gpm.setVerticalAlign(ma.getMAValue());
					} else if (ma.getMAKey() == 54) {
						gpm.setTextAlign(ma.getMAValue());
					} else if (ma.getMAKey() == 55) {
						gpm.setBackgroundColor(HtmlUtils.parseToRGB(Integer.valueOf(ma.getMAValue())));
					}
				}
			}
			modules.add(gpm);
		}
		gen.setModules(modules);
		return gen;
	}

	@Override
	public int generatePage(int id) {
		File genFile = null;
		try {
			String pagePath = "/pages/" + id + ".html";
			genFile = new File(getAbsolutePath(pagePath));

			String templatePath = "/gen.html";
			GenPage genPage = getPageDetail(id);
			Map<String, Object> map = new HashMap<>();
			map.put("page", genPage);
			map.put("static_host", "..");
			String html = FreemarkerUtils.generate(templatePath, map);
			FileUtils.writeStringToFile(genFile, html, "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {

		}
		return 1;
	}

	private String getAbsolutePath(String path) {
		return Constant.getInstance().getProperty("static_upload_path") + path;
	}

	@Override
	public PgPage buildHomePage(VeVenue venue, String languageCode) {
		PgPage pp=new PgPage();
		
		Map<String, Object> params = new HashMap<>();
		params.put("venueID", venue.getId());
		params.put("templateID", 0);
		params.put("pageLanguageCode", languageCode);
		List<PgPage> pageList = findPageList(params);
		if(CollectionUtils.isNotEmpty(pageList)){
			for(PgPage p:pageList){
				deletePage(p.getId());
			}
		}
		
		pp.setPageName("自动生成的首页");
		pp.setPagePublish(0);
		pp.setPageCreateTime(new Date());
		pp.setPageModifyTime(new Date());
		pp.setPageDescription("");
		pp.setPageState(36);
		pp.setPageTypeID(40);
		pp.setSequence(pgPageMapper.getMaxSequence()+1);
		pp.setTemplateID(0);
		pp.setVenueID(venue.getId());
		pp.setPageLanguageCode(languageCode);
		
		pgPageMapper.insert(pp);
		
		//首页大图
		PgPageContent pageContent1 = new PgPageContent();
		pageContent1.setPageID(pp.getId());
		pageContent1.setTemplateID(0);
		pageContent1.setModuleID(472);
		pageContent1.setContentValue(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_homeImage"));
		pageContent1.setContentSequence(1);
		pgPageContentMapper.insert(pageContent1);
		
		//场所名称
		PgPageContent pageContent2 = new PgPageContent();
		pageContent2.setPageID(pp.getId());
		pageContent2.setTemplateID(0);
		pageContent2.setModuleID(473);
		pageContent2.setContentValue(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_venueName"));
		pageContent2.setContentSequence(2);
		pgPageContentMapper.insert(pageContent2);
		
		//首页基本信息
		PgPageContent pageContent3 = new PgPageContent();
		pageContent3.setPageID(pp.getId());
		pageContent3.setTemplateID(0);
		pageContent3.setModuleID(474);
		StringBuffer sb = new StringBuffer();
		sb.append(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_address")); //地址
		sb.append(" \n");
		sb.append(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_postCode")); //邮编
		sb.append(" \n");
		sb.append(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_phone")); //电话
		sb.append(" \n");
		sb.append(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_fax")); //传真
		sb.append(" \n");
		sb.append(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_email")); //邮箱
		sb.append(" \n");
		sb.append(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_website")); //网址
		pageContent3.setContentValue(sb.toString());
		pageContent3.setContentSequence(3);
		pgPageContentMapper.insert(pageContent3);
		
		//视频 模块
		PgPageContent pageContent4 = new PgPageContent();
		pageContent4.setPageID(pp.getId());
		pageContent4.setTemplateID(0);
		pageContent4.setModuleID(475);
		pageContent4.setContentValue(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_homeVideo"));
		pageContent4.setContentSequence(4);
		pgPageContentMapper.insert(pageContent4);
		
		//星级 模块
		if(venue.getAttrs().containsKey("HOTEL_" + languageCode + "_starLevel")){
			PgPageContent pageContent5 = new PgPageContent();
			pageContent5.setPageID(pp.getId());
			pageContent5.setTemplateID(0);
			pageContent5.setModuleID(476);
			String starLevel = getValue(venue.getAttrs(),"HOTEL_" + languageCode + "_starLevel");
			int n = NumberUtils.toInt(starLevel);
			StringBuffer stars = new StringBuffer();
			for(int i=1;i<=n;i++){
				stars.append("★");
			}
			pageContent5.setContentValue(stars.toString());
			pageContent5.setContentSequence(5);
			pgPageContentMapper.insert(pageContent5);
		}
		
		//首页LOGO
		PgPageContent pageContent6 = new PgPageContent();
		pageContent6.setPageID(pp.getId());
		pageContent6.setTemplateID(0);
		pageContent6.setModuleID(477);
		pageContent6.setContentValue(getValue(venue.getAttrs(),"DEFAULT_" + languageCode + "_logImage"));
		pageContent6.setContentSequence(6);
		pgPageContentMapper.insert(pageContent6);
		
		List<MoModuleAttribute> moduleAttrList = moModuleAttributeeMapper.selectByTemplateID(0);
		for(MoModuleAttribute ma : moduleAttrList){
			PgPageModuleAttribute ppma = new PgPageModuleAttribute();
			ppma.setPageID(pp.getId());
			ppma.setTmplateID(0);
			ppma.setModuleID(ma.getID());
			ppma.setMAKey(ma.getMAKey());
			ppma.setMAValue(ma.getMAValue());
			pgPageModuleAttributeMapper.insert(ppma);
		}
		return pp;
	}
	
	private String getValue(Map<String, VeVenueAttr> attrs, String key) {
		if (attrs.containsKey(key)) {
			return attrs.get(key).getAttrValue();
		}
		return "";
	}
}
