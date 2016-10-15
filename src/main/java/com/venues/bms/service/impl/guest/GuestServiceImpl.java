package com.venues.bms.service.impl.guest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.GuCommentMapper;
import com.venues.bms.dao.GuGuestMapper;
import com.venues.bms.dao.GuGuestMessageMapper;
import com.venues.bms.po.GuComment;
import com.venues.bms.po.GuGuest;
import com.venues.bms.po.GuGuestMessage;
import com.venues.bms.service.guest.GuestService;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuGuestMapper guGuestMapper;

	@Autowired
	private GuGuestMessageMapper guGuestMessageMapper;

	@Autowired
	private GuCommentMapper guCommentMapper;

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

	@Override
	public Page<GuComment> findCommentPage(Page<GuComment> page, Map<String, Object> params) {
		int count = guCommentMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<GuComment> list = findCommentList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<GuComment> findCommentList(Map<String, Object> params) {
		List<GuComment> list = guCommentMapper.selectByParams(params);
		for (GuComment comment : list) {
			if (comment.getGuestID() != null) {
				GuGuest guest = guGuestMapper.selectByPrimaryKey(comment.getGuestID());
				if (guest != null) {
					comment.setGuestName(guest.getGuestName());
				}
			}
		}
		return list;
	}

}
