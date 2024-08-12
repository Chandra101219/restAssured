package api.payloads;

import java.util.List;

	public class Pet {
	    int id;
	    Category category;
	    String name;
	    String[] photoUrls;
	    List<Tag> tags;
	    String status;

	    // Nested Category class
	    public static class Category {
	        int id;
	        String name;

	        // Default constructor
	        public Category() {
	        }

	        // Parameterized constructor
	        public Category(int id, String name) {
	            this.id = id;
	            this.name = name;
	        }

	        // Getters and Setters
	        public int getId() {
	            return id;
	        }

	        public void setId(int id) {
	            this.id = id;
	        }

	        public String getName() {
	            return name;
	        }

	        public void setName(String name) {
	            this.name = name;
	        }

	        @Override
	        public String toString() {
	            return "Category{" +
	                    "id=" + id +
	                    ", name='" + name + '\'' +
	                    '}';
	        }
	    }

	    // Nested Tag class
	    public static class Tag {
	        int id;
	        String name;

	        // Default constructor
	        public Tag() {
	        }

	        // Parameterized constructor
	        public Tag(int id, String name) {
	            this.id = id;
	            this.name = name;
	        }

	        // Getters and Setters
	        public int getId() {
	            return id;
	        }

	        public void setId(int id) {
	            this.id = id;
	        }

	        public String getName() {
	            return name;
	        }

	        public void setName(String name) {
	            this.name = name;
	        }

	        @Override
	        public String toString() {
	            return "Tag{" +
	                    "id=" + id +
	                    ", name='" + name + '\'' +
	                    '}';
	        }
	    }

	    // Default constructor
	    public Pet() {
	    }

	    // Parameterized constructor
	    public Pet(int id, Category category, String name, String[] photoUrls, List<Tag> tags, String status) {
	        this.id = id;
	        this.category = category;
	        this.name = name;
	        this.photoUrls = photoUrls;
	        this.tags = tags;
	        this.status = status;
	    }

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Category getCategory() {
	        return category;
	    }

	    public void setCategory(Category category) {
	        this.category = category;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String[] getPhotoUrls() {
	        return photoUrls;
	    }

	    public void setPhotoUrls(String[] photourl) {
	        this.photoUrls = photourl;
	    }

	    public List<Tag> getTags() {
	        return tags;
	    }

	    public void setTags(List<Tag> tags) {
	        this.tags = tags;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	

}
