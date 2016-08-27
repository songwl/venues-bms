package com.venues.bms.service.impl.guest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.GuGuestMapper;
import com.venues.bms.dao.GuGuestMessageMapper;
import com.venues.bms.po.GuGuest;
import com.venues.bms.po.GuGuestMessage;
import com.venues.bms.service.guest.GuestService;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuGuestMapper guGuestMapper;

	@Autowired
	private GuGuestMessageMapper guGuestMessageMapper;

	@Override
	public Page<GuGuest> findGuestPage(Page<GuGuest> page, Map<String, Object> params) {
		int count = guGuestMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<GuGuest> list = findGuestList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<GuGuest> findGuestList(Map<String, Object> params) {
		return guGuestMapper.selectByParams(params);
	}

	@Override
	public List<GuGuestMessage> findGuestMessageByGuestId(Integer guestId) {
		return guGuestMessageMapper.selectByGuestId(guestId);
	}

	@Override
	public int deleteGuest(Integer id) {
		return guGuestMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteGuestMessage(Integer id) {
		return guGuestMessageMapper.deleteByPrimaryKey(id);
	}

}
