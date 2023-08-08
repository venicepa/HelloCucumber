$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/open_customer.feature");
formatter.feature({
  "name": "Is it Friday yet?",
  "description": "  Everybody wants to know when it\u0027s Friday",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "2020-01-01 isn\u0027t Friday",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "today is Year 2020, Month 1, Day 1",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefs.today_is_Year_Month_Day(Integer,Integer,Integer)"
});
formatter.result({
  "status": "passed"
});
});