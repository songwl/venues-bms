package com.venues.bms.service.tpl;

import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.TmpTemplate;

public interface TemplateService {

	Page<TmpTemplate> findTemplatePage(Page<TmpTemplate> page, Map<String, Object> params);

	List<TmpTemplate> findTemplateList(Map<String, Object> params);

	TmpTemplate getTemplate(Integer templateId);

	TmpTemplate saveTemplate(TmpTemplate template);

	int updateTemplate(TmpTemplate template);

	int deleteTemplate(Integer id);

	TmpTemplate getTemplateDetail(Integer id);
}
