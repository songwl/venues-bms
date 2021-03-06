package com.venues.bms.po;

import java.util.Date;

public class GuGuestMessage {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.ID
     *
     * @mbggenerated
     */
    private Integer ID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.GuestID
     *
     * @mbggenerated
     */
    private Integer guestID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.VenueID
     *
     * @mbggenerated
     */
    private Integer venueID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.MessageTitle
     *
     * @mbggenerated
     */
    private String messageTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.MessageContent
     *
     * @mbggenerated
     */
    private String messageContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.MessageTime
     *
     * @mbggenerated
     */
    private Date messageTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.EventName
     *
     * @mbggenerated
     */
    private String eventName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.EventType
     *
     * @mbggenerated
     */
    private String eventType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.EstimatedAttendees
     *
     * @mbggenerated
     */
    private String estimatedAttendees;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.EventStartDate
     *
     * @mbggenerated
     */
    private String eventStartDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.EventEndDate
     *
     * @mbggenerated
     */
    private String eventEndDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.Eventrequirements
     *
     * @mbggenerated
     */
    private String eventrequirements;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.FirstName
     *
     * @mbggenerated
     */
    private String firstName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.LastName
     *
     * @mbggenerated
     */
    private String lastName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.EmailAddress
     *
     * @mbggenerated
     */
    private String emailAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.Phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.Organization
     *
     * @mbggenerated
     */
    private String organization;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_guest_message.OrganizationType
     *
     * @mbggenerated
     */
    private String organizationType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.ID
     *
     * @return the value of tbl_guest_message.ID
     *
     * @mbggenerated
     */
    public Integer getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.ID
     *
     * @param ID the value for tbl_guest_message.ID
     *
     * @mbggenerated
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.GuestID
     *
     * @return the value of tbl_guest_message.GuestID
     *
     * @mbggenerated
     */
    public Integer getGuestID() {
        return guestID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.GuestID
     *
     * @param guestID the value for tbl_guest_message.GuestID
     *
     * @mbggenerated
     */
    public void setGuestID(Integer guestID) {
        this.guestID = guestID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.VenueID
     *
     * @return the value of tbl_guest_message.VenueID
     *
     * @mbggenerated
     */
    public Integer getVenueID() {
        return venueID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.VenueID
     *
     * @param venueID the value for tbl_guest_message.VenueID
     *
     * @mbggenerated
     */
    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.MessageTitle
     *
     * @return the value of tbl_guest_message.MessageTitle
     *
     * @mbggenerated
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.MessageTitle
     *
     * @param messageTitle the value for tbl_guest_message.MessageTitle
     *
     * @mbggenerated
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle == null ? null : messageTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.MessageContent
     *
     * @return the value of tbl_guest_message.MessageContent
     *
     * @mbggenerated
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.MessageContent
     *
     * @param messageContent the value for tbl_guest_message.MessageContent
     *
     * @mbggenerated
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.MessageTime
     *
     * @return the value of tbl_guest_message.MessageTime
     *
     * @mbggenerated
     */
    public Date getMessageTime() {
        return messageTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.MessageTime
     *
     * @param messageTime the value for tbl_guest_message.MessageTime
     *
     * @mbggenerated
     */
    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.EventName
     *
     * @return the value of tbl_guest_message.EventName
     *
     * @mbggenerated
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.EventName
     *
     * @param eventName the value for tbl_guest_message.EventName
     *
     * @mbggenerated
     */
    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.EventType
     *
     * @return the value of tbl_guest_message.EventType
     *
     * @mbggenerated
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.EventType
     *
     * @param eventType the value for tbl_guest_message.EventType
     *
     * @mbggenerated
     */
    public void setEventType(String eventType) {
        this.eventType = eventType == null ? null : eventType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.EstimatedAttendees
     *
     * @return the value of tbl_guest_message.EstimatedAttendees
     *
     * @mbggenerated
     */
    public String getEstimatedAttendees() {
        return estimatedAttendees;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.EstimatedAttendees
     *
     * @param estimatedAttendees the value for tbl_guest_message.EstimatedAttendees
     *
     * @mbggenerated
     */
    public void setEstimatedAttendees(String estimatedAttendees) {
        this.estimatedAttendees = estimatedAttendees == null ? null : estimatedAttendees.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.EventStartDate
     *
     * @return the value of tbl_guest_message.EventStartDate
     *
     * @mbggenerated
     */
    public String getEventStartDate() {
        return eventStartDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.EventStartDate
     *
     * @param eventStartDate the value for tbl_guest_message.EventStartDate
     *
     * @mbggenerated
     */
    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate == null ? null : eventStartDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.EventEndDate
     *
     * @return the value of tbl_guest_message.EventEndDate
     *
     * @mbggenerated
     */
    public String getEventEndDate() {
        return eventEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.EventEndDate
     *
     * @param eventEndDate the value for tbl_guest_message.EventEndDate
     *
     * @mbggenerated
     */
    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate == null ? null : eventEndDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.Eventrequirements
     *
     * @return the value of tbl_guest_message.Eventrequirements
     *
     * @mbggenerated
     */
    public String getEventrequirements() {
        return eventrequirements;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.Eventrequirements
     *
     * @param eventrequirements the value for tbl_guest_message.Eventrequirements
     *
     * @mbggenerated
     */
    public void setEventrequirements(String eventrequirements) {
        this.eventrequirements = eventrequirements == null ? null : eventrequirements.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.FirstName
     *
     * @return the value of tbl_guest_message.FirstName
     *
     * @mbggenerated
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.FirstName
     *
     * @param firstName the value for tbl_guest_message.FirstName
     *
     * @mbggenerated
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.LastName
     *
     * @return the value of tbl_guest_message.LastName
     *
     * @mbggenerated
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.LastName
     *
     * @param lastName the value for tbl_guest_message.LastName
     *
     * @mbggenerated
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.EmailAddress
     *
     * @return the value of tbl_guest_message.EmailAddress
     *
     * @mbggenerated
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.EmailAddress
     *
     * @param emailAddress the value for tbl_guest_message.EmailAddress
     *
     * @mbggenerated
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress == null ? null : emailAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.Phone
     *
     * @return the value of tbl_guest_message.Phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.Phone
     *
     * @param phone the value for tbl_guest_message.Phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.Organization
     *
     * @return the value of tbl_guest_message.Organization
     *
     * @mbggenerated
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.Organization
     *
     * @param organization the value for tbl_guest_message.Organization
     *
     * @mbggenerated
     */
    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_guest_message.OrganizationType
     *
     * @return the value of tbl_guest_message.OrganizationType
     *
     * @mbggenerated
     */
    public String getOrganizationType() {
        return organizationType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_guest_message.OrganizationType
     *
     * @param organizationType the value for tbl_guest_message.OrganizationType
     *
     * @mbggenerated
     */
    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType == null ? null : organizationType.trim();
    }
}