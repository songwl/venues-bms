package com.venues.bms.service.impl.tpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.TplTemplateMapper;
import com.venues.bms.po.TplTemplate;
import com.venues.bms.service.tpl.TemplateService;

@Service("templateService")
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TplTemplateMapper tplTemplateMapper;

	@Override
	public Page<TplTemplate> findTemplatePage(Page<TplTemplate> page, Map<String, Object> params) {
		int count = tplTemplateMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<TplTemplate> list = findTemplateList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<TplTemplate> findTemplateList(Map<String, Object> params) {
		return tplTemplateMapper.selectByParams(params);
	}

	@Override
	public TplTemplate getTemplate(Integer templateId) {
		return tplTemplateMapper.selectByPrimaryKey(templateId);
	}

	@Override
	public TplTemplate saveTemplate(TplTemplate template) {
		tplTemplateMapper.insert(template);
		return template;
	}

	@Override
	public int updateTemplate(TplTemplate template) {
		return tplTemplateMapper.updateByPrimaryKeySelective(template);
	}

}
