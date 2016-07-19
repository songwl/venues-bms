package com.venues.bms.service.tpl;

import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.TplTemplate;

public interface TemplateService {

	Page<TplTemplate> findTemplatePage(Page<TplTemplate> page, Map<String, Object> params);

	List<TplTemplate> findTemplateList(Map<String, Object> params);

	TplTemplate getTemplate(Integer templateId);

	TplTemplate saveTemplate(TplTemplate template);

	int updateTemplate(TplTemplate template);
}
