package com.yhao.vvv;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class Stepdefs {

  @Given("today is Year {int}, Month {int}, Day {int}")
  public void today_is_Year_Month_Day(Integer int1, Integer int2, Integer int3) {
    // Write code here that turns the phrase above into concrete actions
    assert 1 == 1;
  }

}
