package com.quiz.cloud.skel.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
    
    @Entity
	@Table(name = "Result")
	public class Result extends AbstractEntity implements Serializable{
	    
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected Long mId;

	    private String userName;

	    private int score;
	    
	    private boolean timeLifeline;
	    

	    private Date playDateTime;

		

		public boolean isTimeLifeline() {
			return timeLifeline;
		}

		public void setTimeLifeline(boolean timeLifeline) {
			this.timeLifeline = timeLifeline;
		}

		public Long getId() {
			return mId;
		}

		public void setId(Long mId) {
			this.mId = mId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public Date getPlayDateTime() {
			return playDateTime;
		}

		public void setPlayDateTime(Date playDateTime) {
			this.playDateTime = playDateTime;
		}
		
		

		public Result() {
			super();
		}

		public Result(String userName, int score, Date playDateTime,boolean timeLifeline) {
			super();
			this.userName = userName;
			this.score = score;
			this.playDateTime = playDateTime;
			this.timeLifeline=timeLifeline;
		}

		@Override
		public String toString() {
			return "Result [mId=" + mId + ", userName=" + userName + ", score=" + score + ", playDateTime="
					+ playDateTime + "]";
		}
	    
			
		
	    
	}


