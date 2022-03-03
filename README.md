<p class="has-line-data" data-line-start="0" data-line-end="2"><a href="http://README.md">README.md</a><br>
Project: Innervation assignment</p>
<p class="has-line-data" data-line-start="3" data-line-end="7">Technical Spec:<br>
Java 8, Spring boot, Apache Camel, cfx<br>
Database: H2<br>
Build tool: Maven</p>
<p class="has-line-data" data-line-start="8" data-line-end="12">How to run:<br>
Checkout the code from github repository-&gt; Details shared by url<br>
Open the project in eclipse as existing maven project<br>
Right click on SweApplication.java class -&gt; Run as -&gt; Java Application</p>
<p class="has-line-data" data-line-start="13" data-line-end="15">**Endpoint: **<br>
<a href="http://localhost:9080/getTaxDetails">http://localhost:9080/getTaxDetails</a></p>
<p class="has-line-data" data-line-start="16" data-line-end="17">Sample Request:</p>
<p class="has-line-data" data-line-start="18" data-line-end="28">{<br>
“vehicle”: {<br>
“type”: “car”<br>
},<br>
“dates”: [<br>
“2022-02-01 7:29:27”,<br>
“2022-02-01 8:29:27”,<br>
“2022-02-01 9:29:27”<br>
]<br>
}</p>
<p class="has-line-data" data-line-start="29" data-line-end="31">Sample Response:<br>
{“response”:{“responseCode”:“200”,“responseMessage”:“Success”},“currency”:“SEK”,“amount”:26}</p>
<p class="has-line-data" data-line-start="33" data-line-end="40">H2 Database:<br>
<a href="http://localhost:9080/h2-console/">http://localhost:9080/h2-console/</a><br>
Connection URL:<br>
jdbc:h2:mem:testdb<br>
UserName:<br>
sa<br>
Password: password</p>
<p class="has-line-data" data-line-start="41" data-line-end="42">New Implementations:</p>
<ol>
<li class="has-line-data" data-line-start="42" data-line-end="43">Check for the month of July (Zero Tax)</li>
<li class="has-line-data" data-line-start="43" data-line-end="45">Check if the next day is a public holiday, only consider 1 day before public holiday as the exact days are not mentioned.</li>
</ol>
<p class="has-line-data" data-line-start="45" data-line-end="48">DB Tables:<br>
1- PUBLICHOLIDAYS<br>
This table contains the list of public holidays. Can be change from the data.sql file</p>
<p class="has-line-data" data-line-start="49" data-line-end="52">2- TAXCALCULATOR<br>
This table has the tax charges lined with hours and mins.<br>
Can be change from the data.sql file</p>
<p class="has-line-data" data-line-start="54" data-line-end="56">3 -TOLLFREEVEHICLES<br>
This tables has the list of toll free vechicles. Can be change from the data.sql file</p>
<p class="has-line-data" data-line-start="58" data-line-end="59">Containerise by Docker.</p>
<p class="has-line-data" data-line-start="60" data-line-end="63">Remaining Tasks:<br>
Code analysis tool implementation<br>
Some test cases</p>