package com.venues.bms.web.component;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.venues.bms.core.freemarker.IDictDataLoader;
import com.venues.bms.core.model.LabelValue;
import com.venues.bms.po.SysUser;
import com.venues.bms.service.sys.UserService;

@Component("sysUserComponent")
public class SysUserComponent implements IDictDataLoader {

	@Autowired
	private UserService userService;

	@Override
	public List<LabelValue> loadDataList(String keyCode) {
		List<LabelValue> list = new ArrayList<>();
		if (StringUtils.isNotBlank(keyCode)) {
			Integer id = NumberUtils.toInt(keyCode);
			SysUser user = userService.getSysUserByUserId(id);
			if (user != null) {
				LabelValue lv = new LabelValue(user.getUserName(), keyCode);
				list.add(lv);
			}

		}
		return list;
	}
}
