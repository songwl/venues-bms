package com.venues.bms.service.guest;

import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.GuComment;
import com.venues.bms.po.GuGuest;
import com.venues.bms.po.GuGuestMessage;

public interface GuestService {

	Page<GuGuest> findGuestPage(Page<GuGuest> page, Map<String, Object> params);

	List<GuGuest> findGuestList(Map<String, Object> params);

	List<GuGuestMessage> findGuestMessageByGuestId(Integer guestId);

	int deleteGuest(Integer id);

	int deleteGuestMessage(Integer id);

	Page<GuComment> findCommentPage(Page<GuComment> page, Map<String, Object> params);

	List<GuComment> findCommentList(Map<String, Object> params);
	
	int deleteComment(Integer id);
}
