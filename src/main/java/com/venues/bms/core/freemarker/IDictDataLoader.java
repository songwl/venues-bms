package com.venues.bms.core.freemarker;

import java.util.List;

import com.venues.bms.core.model.LabelValue;

/**
 * Created by lancey on 15/3/19.
 */
public interface IDictDataLoader {

	/**
	 * 通过数据字典拿取数据
	 * @param keyCode
	 * @return
	 */
	List<LabelValue> loadDataList(final String keyCode);
}
