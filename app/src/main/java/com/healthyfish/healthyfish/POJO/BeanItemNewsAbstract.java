package com.healthyfish.healthyfish.POJO;

public class BeanItemNewsAbstract {
	private String url;
	private int idOffset; 
	private String img; //标题图片
	private String title; //标题
//		private String content; //内容
	private String category;
	private String timestamp; //时间
//		private String editor; //编者
//	private int reads; //阅读数 
//	private int likes; //点赞数
	
	public BeanItemNewsAbstract(){}
	public BeanItemNewsAbstract(BeanItemNews bean){
		this.img=bean.getImg();
		this.timestamp = bean.getTimestamp();
		this.title = bean.getTitle();
		this.category = bean.getCategory();
		this.url = bean.getUrl();
	}
	
	public String getUrl() {return url;}
	public void setUrl(String url) {this.url = url;}
	public int getIdOffset() {return idOffset;}
	public void setIdOffset(int idOffset) {this.idOffset = idOffset;}
	public String getImg() {return img;}
	public void setImg(String img) {this.img = img;}
	public String getTitle() {return title;	}
	public void setTitle(String title) {this.title = title;	}
	public String getCategory() {return category;}
	public void setCategory(String category) {this.category = category;}
//		public String getContent() {return content;	}
//		public void setContent(String content) {this.content = content;	}
	public String getTimestamp() {return timestamp;}
	public void setTimestamp(String timestamp) {this.timestamp = timestamp;}
//		public String getEditor() {return editor;}
//		public void setEditor(String editor) {this.editor = editor;}
//	public int getReads() {return reads;}
//	public void setReads(int reads) {this.reads = reads;}
//	public int getLikes() {return likes;}
//	public void setLikes(int likes) {this.likes = likes;}
}
