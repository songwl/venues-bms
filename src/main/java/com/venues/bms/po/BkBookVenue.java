package com.venues.bms.po;

public class BkBookVenue {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_book_venue.ID
     *
     * @mbggenerated
     */
    private Integer ID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_book_venue.BookID
     *
     * @mbggenerated
     */
    private Integer bookID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_book_venue.VenueID
     *
     * @mbggenerated
     */
    private Integer venueID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_book_venue.BookVenueSequence
     *
     * @mbggenerated
     */
    private Integer bookVenueSequence;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_book_venue.ID
     *
     * @return the value of tbl_book_venue.ID
     *
     * @mbggenerated
     */
    public Integer getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_book_venue.ID
     *
     * @param ID the value for tbl_book_venue.ID
     *
     * @mbggenerated
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_book_venue.BookID
     *
     * @return the value of tbl_book_venue.BookID
     *
     * @mbggenerated
     */
    public Integer getBookID() {
        return bookID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_book_venue.BookID
     *
     * @param bookID the value for tbl_book_venue.BookID
     *
     * @mbggenerated
     */
    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_book_venue.VenueID
     *
     * @return the value of tbl_book_venue.VenueID
     *
     * @mbggenerated
     */
    public Integer getVenueID() {
        return venueID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_book_venue.VenueID
     *
     * @param venueID the value for tbl_book_venue.VenueID
     *
     * @mbggenerated
     */
    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_book_venue.BookVenueSequence
     *
     * @return the value of tbl_book_venue.BookVenueSequence
     *
     * @mbggenerated
     */
    public Integer getBookVenueSequence() {
        return bookVenueSequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_book_venue.BookVenueSequence
     *
     * @param bookVenueSequence the value for tbl_book_venue.BookVenueSequence
     *
     * @mbggenerated
     */
    public void setBookVenueSequence(Integer bookVenueSequence) {
        this.bookVenueSequence = bookVenueSequence;
    }
}