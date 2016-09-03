package com.venues.bms.service.impl.page;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Constant;
import com.venues.bms.core.model.Page;
import com.venues.bms.core.utils.FreemarkerUtils;
import com.venues.bms.core.utils.ResourceUtils;
import com.venues.bms.dao.MoModuleMapper;
import com.venues.bms.dao.PgPageContentMapper;
import com.venues.bms.dao.PgPageMapper;
import com.venues.bms.dao.PgPageModuleAttributeMapper;
import com.venues.bms.dao.TmpTemplateMapper;
import com.venues.bms.po.MoModule;
import com.venues.bms.po.PgPage;
import com.venues.bms.po.PgPageContent;
import com.venues.bms.po.PgPageModuleAttribute;
import com.venues.bms.po.TmpTemplate;
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
		gen.setBackgroundColor(template.getTemplateColor());
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
					gpm.setContent(pageContentList.get(0).getContentValue());
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
						gpm.setColor(ma.getMAValue());
					} else if (ma.getMAKey() == 52) {
						gpm.setOpacity(ma.getMAValue());
					} else if (ma.getMAKey() == 53) {
						gpm.setVerticalAlign(ma.getMAValue());
					} else if (ma.getMAKey() == 54) {
						gpm.setTextAlign(ma.getMAValue());
					} else if (ma.getMAKey() == 55) {
						gpm.setBackgroundColor(ma.getMAValue());
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
			map.put("static_host", Constant.getInstance().getProperty("static_host"));
			String html = FreemarkerUtils.generate(templatePath, map);
			FileUtils.writeStringToFile(genFile, html);
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

	public static void main(String[] args) {
		File genFile = null;
		try {
			genFile = new File(ResourceUtils.getRootPath("/upload/123.html"));

			String templatePath = "/gen.html";

			Map<String, Object> map = new HashMap<>();
			map.put("content", "I am song!");
			String html = FreemarkerUtils.generate(templatePath, map);
			FileUtils.writeStringToFile(genFile, html);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		}
	}
}
