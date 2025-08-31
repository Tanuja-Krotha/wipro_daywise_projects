package com.wipro.productservice.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {
	 	private Long id;
	    
	    @NotBlank(message = "Product name is required")
	    private String name;
	    
	    private String description;
	    
	    @NotNull(message = "Price is required")
	    @Min(value = 0, message = "Price must be greater than or equal to 0")
	    private Double price;
	    
	    @NotNull(message = "Quantity is required")
	    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
	    private Integer quantity;
	    
	    private String  imageUrl;

		
	    
	    public ProductDTO() {
			super();
		}

		public ProductDTO(Long id, @NotBlank(message = "Product name is required") String name, String description,
				@NotNull(message = "Price is required") @Min(value = 0, message = "Price must be greater than or equal to 0") Double price,
				@NotNull(message = "Quantity is required") @Min(value = 0, message = "Quantity must be greater than or equal to 0") Integer quantity,
				String imageUrl) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.quantity = quantity;
			this.imageUrl = imageUrl;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImage(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		@Override
		public String toString() {
			return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
					+ ", quantity=" + quantity + ", imageUrl=" + imageUrl + "]";
		}
	    
	    

}
