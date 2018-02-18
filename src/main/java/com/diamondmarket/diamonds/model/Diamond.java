package com.diamondmarket.diamonds.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Diamond {
		
	 @JsonProperty("diamondId")
	  private String diamondId = null;

	  @JsonProperty("diamondType")
	  private String diamondType = null;

	  @JsonProperty("carat")
	  private Long carat = null;
	  
	  @JsonProperty("weight")
	  private Double weight = null;

	  @JsonProperty("prize")
	  private Long prize = null;

	public String getDiamondId() {
		return diamondId;
	}

	public void setDiamondId(String diamondId) {
		this.diamondId = diamondId;
	}

	public String getDiamondType() {
		return diamondType;
	}

	public void setDiamondType(String diamondType) {
		this.diamondType = diamondType;
	}

	public Long getCarat() {
		return carat;
	}

	public void setCarat(Long carat) {
		this.carat = carat;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Long getPrize() {
		return prize;
	}

	public void setPrize(Long prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Diamond [diamondId=" + diamondId + ", diamondType=" + diamondType + ", carat=" + carat + ", weight="
				+ weight + ", prize=" + prize + "]";
	}
	
}
