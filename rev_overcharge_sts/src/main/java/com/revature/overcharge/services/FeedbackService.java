package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Feedback;

public interface FeedbackService {
	
	public Feedback addFeedback(int deckId, Feedback f);

    public Feedback getFeedback(int id);

    public Feedback updateFeedback(Feedback newFeedback);

    public boolean deleteFeedback(int id);

    public List<Feedback> getFeedbacksByDeckId(int deckId);

    public List<Feedback> getAllFeedbacks();

}
