package com.ecommerceback.Model.Util;

public class PaginationApi {

    private long current_rows;
    private long total_rows;
    private long rows_remaining;
    private long total_pages;
    private long pages_remaining;
    private String previous_page;
    private long previous_page_offset;
    private String next_page;
    private long next_page_offset;

    public PaginationApi() {
    }

    public PaginationApi(long current_rows, long total_rows, long rows_remaining, long total_pages, long pages_remaining, String previous_page, long previous_page_offset, String next_page, long next_page_offset) {
        this.current_rows = current_rows;
        this.total_rows = total_rows;
        this.rows_remaining = rows_remaining;
        this.total_pages = total_pages;
        this.pages_remaining = pages_remaining;
        this.previous_page = previous_page;
        this.previous_page_offset = previous_page_offset;
        this.next_page = next_page;
        this.next_page_offset = next_page_offset;
    }

    public long getCurrent_rows() {
        return current_rows;
    }

    public void setCurrent_rows(long current_rows) {
        this.current_rows = current_rows;
    }

    public long getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(long total_rows) {
        this.total_rows = total_rows;
    }

    public long getRows_remaining() {
        return rows_remaining;
    }

    public void setRows_remaining(long rows_remaining) {
        this.rows_remaining = rows_remaining;
    }

    public long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(long total_pages) {
        this.total_pages = total_pages;
    }

    public long getPages_remaining() {
        return pages_remaining;
    }

    public void setPages_remaining(long pages_remaining) {
        this.pages_remaining = pages_remaining;
    }

    public String getPrevious_page() {
        return previous_page;
    }

    public void setPrevious_page(String previous_page) {
        this.previous_page = previous_page;
    }

    public long getPrevious_page_offset() {
        return previous_page_offset;
    }

    public void setPrevious_page_offset(long previous_page_offset) {
        this.previous_page_offset = previous_page_offset;
    }

    public String getNext_page() {
        return next_page;
    }

    public void setNext_page(String next_page) {
        this.next_page = next_page;
    }

    public long getNext_page_offset() {
        return next_page_offset;
    }

    public void setNext_page_offset(long next_page_offset) {
        this.next_page_offset = next_page_offset;
    }
}

