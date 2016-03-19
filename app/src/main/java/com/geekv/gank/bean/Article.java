package com.geekv.gank.bean;

import java.util.List;

public class Article {

	private boolean error;

	private List<Results> results ;

	public void setError(boolean error){
		this.error = error;
	}
	public boolean getError(){
		return this.error;
	}
	public void setResults(List<Results> results){
		this.results = results;
	}
	public List<Results> getResults(){
		return this.results;
	}
	
	@Override
	public String toString() {
		return "Article [error=" + error + ", results=" + results + "]";
	}

	public class Results {
		private String _id;

		private String _ns;

		private String createdAt;

		private String desc;

		private String publishedAt;

		private String source;

		private String type;

		private String url;

		private boolean used;

		private User user;

		private String who;

		public void set_id(String _id){
			this._id = _id;
		}
		public String get_id(){
			return this._id;
		}
		public void set_ns(String _ns){
			this._ns = _ns;
		}
		public String get_ns(){
			return this._ns;
		}
		public void setCreatedAt(String createdAt){
			this.createdAt = createdAt;
		}
		public String getCreatedAt(){
			return this.createdAt;
		}
		public void setDesc(String desc){
			this.desc = desc;
		}
		public String getDesc(){
			return this.desc;
		}
		public void setPublishedAt(String publishedAt){
			this.publishedAt = publishedAt;
		}
		public String getPublishedAt(){
			return this.publishedAt;
		}
		public void setSource(String source){
			this.source = source;
		}
		public String getSource(){
			return this.source;
		}
		public void setType(String type){
			this.type = type;
		}
		public String getType(){
			return this.type;
		}
		public void setUrl(String url){
			this.url = url;
		}
		public String getUrl(){
			return this.url;
		}
		public void setUsed(boolean used){
			this.used = used;
		}
		public boolean getUsed(){
			return this.used;
		}
		public void setUser(User user){
			this.user = user;
		}
		public User getUser(){
			return this.user;
		}
		public void setWho(String who){
			this.who = who;
		}
		public String getWho(){
			return this.who;
		}

		@Override
		public String toString() {
			return "Results [_id=" + _id + ", _ns=" + _ns + ", createdAt="
					+ createdAt + ", desc=" + desc + ", publishedAt="
					+ publishedAt + ", source=" + source + ", type=" + type
					+ ", url=" + url + ", used=" + used + ", user=" + user
					+ ", who=" + who + "]";
		}

		public class User {
			private String _id;

			private String _ns;

			private String access_token;

			private String avatar_url;

			private String blog;

			private String company;

			private String createdAt;

			private String created_at;

			private String email;

			private String events_url;

			private int followers;

			private String followers_url;

			private int following;

			private String following_url;

			private String gists_url;

			private String gravatar_id;

			private String html_url;

			private int id;

			private String identity;

			private String location;

			private String login;

			private String name;

			private String organizations_url;

			private int public_gists;

			private int public_repos;

			private String received_events_url;

			private String repos_url;

			private boolean site_admin;

			private String starred_url;

			private String subscriptions_url;

			private String type;

			private String updated_at;

			private String url;

			public void set_id(String _id){
				this._id = _id;
			}
			public String get_id(){
				return this._id;
			}
			public void set_ns(String _ns){
				this._ns = _ns;
			}
			public String get_ns(){
				return this._ns;
			}
			public void setAccess_token(String access_token){
				this.access_token = access_token;
			}
			public String getAccess_token(){
				return this.access_token;
			}
			public void setAvatar_url(String avatar_url){
				this.avatar_url = avatar_url;
			}
			public String getAvatar_url(){
				return this.avatar_url;
			}
			public void setBlog(String blog){
				this.blog = blog;
			}
			public String getBlog(){
				return this.blog;
			}
			public void setCompany(String company){
				this.company = company;
			}
			public String getCompany(){
				return this.company;
			}
			public void setCreatedAt(String createdAt){
				this.createdAt = createdAt;
			}
			public String getCreatedAt(){
				return this.createdAt;
			}
			public void setCreated_at(String created_at){
				this.created_at = created_at;
			}
			public String getCreated_at(){
				return this.created_at;
			}
			public void setEmail(String email){
				this.email = email;
			}
			public String getEmail(){
				return this.email;
			}
			public void setEvents_url(String events_url){
				this.events_url = events_url;
			}
			public String getEvents_url(){
				return this.events_url;
			}
			public void setFollowers(int followers){
				this.followers = followers;
			}
			public int getFollowers(){
				return this.followers;
			}
			public void setFollowers_url(String followers_url){
				this.followers_url = followers_url;
			}
			public String getFollowers_url(){
				return this.followers_url;
			}
			public void setFollowing(int following){
				this.following = following;
			}
			public int getFollowing(){
				return this.following;
			}
			public void setFollowing_url(String following_url){
				this.following_url = following_url;
			}
			public String getFollowing_url(){
				return this.following_url;
			}
			public void setGists_url(String gists_url){
				this.gists_url = gists_url;
			}
			public String getGists_url(){
				return this.gists_url;
			}
			public void setGravatar_id(String gravatar_id){
				this.gravatar_id = gravatar_id;
			}
			public String getGravatar_id(){
				return this.gravatar_id;
			}
			public void setHtml_url(String html_url){
				this.html_url = html_url;
			}
			public String getHtml_url(){
				return this.html_url;
			}
			public void setId(int id){
				this.id = id;
			}
			public int getId(){
				return this.id;
			}
			public void setIdentity(String identity){
				this.identity = identity;
			}
			public String getIdentity(){
				return this.identity;
			}
			public void setLocation(String location){
				this.location = location;
			}
			public String getLocation(){
				return this.location;
			}
			public void setLogin(String login){
				this.login = login;
			}
			public String getLogin(){
				return this.login;
			}
			public void setName(String name){
				this.name = name;
			}
			public String getName(){
				return this.name;
			}
			public void setOrganizations_url(String organizations_url){
				this.organizations_url = organizations_url;
			}
			public String getOrganizations_url(){
				return this.organizations_url;
			}
			public void setPublic_gists(int public_gists){
				this.public_gists = public_gists;
			}
			public int getPublic_gists(){
				return this.public_gists;
			}
			public void setPublic_repos(int public_repos){
				this.public_repos = public_repos;
			}
			public int getPublic_repos(){
				return this.public_repos;
			}
			public void setReceived_events_url(String received_events_url){
				this.received_events_url = received_events_url;
			}
			public String getReceived_events_url(){
				return this.received_events_url;
			}
			public void setRepos_url(String repos_url){
				this.repos_url = repos_url;
			}
			public String getRepos_url(){
				return this.repos_url;
			}
			public void setSite_admin(boolean site_admin){
				this.site_admin = site_admin;
			}
			public boolean getSite_admin(){
				return this.site_admin;
			}
			public void setStarred_url(String starred_url){
				this.starred_url = starred_url;
			}
			public String getStarred_url(){
				return this.starred_url;
			}
			public void setSubscriptions_url(String subscriptions_url){
				this.subscriptions_url = subscriptions_url;
			}
			public String getSubscriptions_url(){
				return this.subscriptions_url;
			}
			public void setType(String type){
				this.type = type;
			}
			public String getType(){
				return this.type;
			}
			public void setUpdated_at(String updated_at){
				this.updated_at = updated_at;
			}
			public String getUpdated_at(){
				return this.updated_at;
			}
			public void setUrl(String url){
				this.url = url;
			}
			public String getUrl(){
				return this.url;
			}
			@Override
			public String toString() {
				return "User [_id=" + _id + ", _ns=" + _ns + ", access_token="
						+ access_token + ", avatar_url=" + avatar_url
						+ ", blog=" + blog + ", company=" + company
						+ ", createdAt=" + createdAt + ", created_at="
						+ created_at + ", email=" + email + ", events_url="
						+ events_url + ", followers=" + followers
						+ ", followers_url=" + followers_url + ", following="
						+ following + ", following_url=" + following_url
						+ ", gists_url=" + gists_url + ", gravatar_id="
						+ gravatar_id + ", html_url=" + html_url + ", id=" + id
						+ ", identity=" + identity + ", location=" + location
						+ ", login=" + login + ", name=" + name
						+ ", organizations_url=" + organizations_url
						+ ", public_gists=" + public_gists + ", public_repos="
						+ public_repos + ", received_events_url="
						+ received_events_url + ", repos_url=" + repos_url
						+ ", site_admin=" + site_admin + ", starred_url="
						+ starred_url + ", subscriptions_url="
						+ subscriptions_url + ", type=" + type
						+ ", updated_at=" + updated_at + ", url=" + url + "]";
			}
			
		}
	}
}
