package com.venues.bms.service.impl.tpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.MoModuleAttributeMapper;
import com.venues.bms.dao.MoModuleMapper;
import com.venues.bms.dao.TmpTemplateMapper;
import com.venues.bms.po.MoModule;
import com.venues.bms.po.TmpTemplate;
import com.venues.bms.service.tpl.TemplateService;

@Service("templateService")
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TmpTemplateMapper tmpTemplateMapper;

	@Autowired
	private MoModuleMapper moModuleMapper;

	@Autowired
	private MoModuleAttributeMapper moModuleAttributeMapper;

	@Override
	public Page<TmpTemplate> findTemplatePage(Page<TmpTemplate> page, Map<String, Object> params) {
		int count = tmpTemplateMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<TmpTemplate> list = findTemplateList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<TmpTemplate> findTemplateList(Map<String, Object> params) {
		return tmpTemplateMapper.selectByParams(params);
	}

	@Override
	public TmpTemplate getTemplate(Integer templateId) {
		return tmpTemplateMapper.selectByPrimaryKey(templateId);
	}

	@Override
	public TmpTemplate saveTemplate(TmpTemplate template) {
		tmpTemplateMapper.insert(template);
		return template;
	}

	@Override
	public int updateTemplate(TmpTemplate template) {
		return tmpTemplateMapper.updateByPrimaryKeySelective(template);
	}

	@Override
	public int deleteTemplate(Integer id) {
		return tmpTemplateMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TmpTemplate getTemplateDetail(Integer templateId) {
		TmpTemplate template = tmpTemplateMapper.selectByPrimaryKey(templateId);
		List<MoModule> moduleList = moModuleMapper.selectByTemplateId(template.getId());
		return template;
	}

}
