package com.ecommerceback.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationApi {

    @JsonProperty("current_rows")
    private long currentRows;
    @JsonProperty("total_rows")
    private long totalRows;
    @JsonProperty("rows_remaining")
    private long rowsRemaining;
    @JsonProperty("total_pages")
    private long totalPages;
    @JsonProperty("pages_remaining")
    private long pagesRemaining;
    @JsonProperty("previous_page")
    private String previousPage;
    @JsonProperty("previous_page_offset")
    private long previousPageOffset;
    @JsonProperty("next_page")
    private String nextPage;
    @JsonProperty("next_page_offset")
    private long nextPageOffset;
}

