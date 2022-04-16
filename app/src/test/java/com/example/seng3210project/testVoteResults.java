package com.example.seng3210project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testVoteResults {

@Test
    public void moreYes(){
    assertEquals(true,voter_voting_results_page.whichOneWon(5,2));
    }
@Test
    public void moreNo(){
    assertEquals(false,voter_voting_results_page.whichOneWon(2,4));
    }
    @Test
    public void sameVote(){
    assertEquals(false,voter_voting_results_page.whichOneWon(5,5));
    }

}
