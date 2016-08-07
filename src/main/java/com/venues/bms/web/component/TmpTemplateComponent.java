package com.venues.bms.web.component;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.venues.bms.core.freemarker.IDictDataLoader;
import com.venues.bms.core.model.LabelValue;
import com.venues.bms.po.TmpTemplate;
import com.venues.bms.service.tpl.TemplateService;

@Component("tmpTemplateComponent")
public class TmpTemplateComponent implements IDictDataLoader {

	@Autowired
	private TemplateService templateService;

	@Override
	public List<LabelValue> loadDataList(String keyCode) {
		List<LabelValue> list = new ArrayList<>();
		if (StringUtils.isNotBlank(keyCode)) {
			Integer id = NumberUtils.toInt(keyCode);
			TmpTemplate tmp = templateService.getTemplate(id);
			if (tmp != null) {
				LabelValue lv = new LabelValue(tmp.getTemplateName().toString(), tmp.getId().toString());
				list.add(lv);
			}
		}
		return list;
	}

}
