package app;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class LoginInPage implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/LoginInPage.html";

    @Override
    public void handle(Context context) throws Exception {
        // // Create a simple HTML webpage in a String
        String html = "<html>";

        // // Add some Head information
        html = html + "<head>" + 
               "<title>Overview</title>";

        // // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        // // Add the body
        html = html + "<body>";

        // // Add the topnav
        // // This uses a Java v15+ Text Block
        html = html + """
            <div class='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
		        <a href="equipment.html">Climate Equipment</a>
                <a href='page2A.html'>Sub Task 2.A</a>
                <a href='page2B.html'>Sub Task 2.B</a>
                <a href='page2C.html'>Sub Task 2.C</a>
                <a href='page3A.html'>Sub Task 3.A</a>
                <a href='page3B.html'>Sub Task 3.B</a>
                <a href='page3C.html'>Sub Task 3.C</a>
            </div>
        """;

        // // Add header content block
        html = html + """
            <div class='summary-box'>
                <h3>Summary of attributes</h3>
                <p>
                    The dataset contains climate record from weather stations in Australia between 1970 and 2022.
                    Each record includes a station id, site name, locations and measurements such as maximum and minimum 
                    temperature, rainfall, evaporation, humidity, cloud cover and sunshine hours. Data quality is indicated 
                    by flags for each metric. A date table allows grouping by various time intervals, supporting flexible 
                    analysis of climate trends over time.
                </p>
            </div>

            <div class = 'dataset-grid'>
                <div class = 'dataset-table'>
                    <h4>Dataset: Location</h4>
                    <table class = 'attribute-table'>
                        <thead>
                            <tr>
                                <th>Attribute</th>
                                <th><div class='second-column'>Label</th>
                                <th><div class='thrid-column'>Description</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>locationID</td>
                                <td>location number</td>
                                <td>The unique number to reprsent each location</td>
                            </tr>
                            <tr>
                                <td>stationID</td>
                                <td>station number</td>
                                <td>The unique number to reprsent each station</td>
                            </tr>
                            <tr>
                                <td>site</td>
                                <td>site number</td>
                                <td>It represents a unique weather station location in Australia </td>
                            </tr>
                            <tr>
                                <td>name</td>
                                <td>weather station name</td>
                                <td>The name of the weather station</td>
                            </tr>
                            <tr>
                                <td>lat</td>
                                <td>latitude</td>
                                <td>The north–south geographic coordinate of the station</td>
                            </tr>
                            <tr>
                                <td>long</td>
                                <td>longtitude</td>
                                <td>The east–west geographic coordinate of the station</td>
                            </tr>
                            <tr>
                                <td>state</td>
                                <td>precipitation number</td>
                                <td>The Australian state or territory where the station is located</td>
                            </tr>
                            <tr>
                                <td>region</td>
                                <td>sunshine number</td>
                                <td>The unique number to reprsent each sunshine data</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class = 'dataset-table'>
                    <h4>Dataset: Temperature</h4>
                    <table class = 'attribute-table'>
                        <thead>
                            <tr>
                                <th>Attribute</th>
                                <th><div class='second-column'>Label</th>
                                <th><div class='thrid-column'>Description</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>temperatureID</td>
                                <td>Temperature record ID</td>
                                <td>An identifier used to uniquely distinguish each temperature data entry</td>
                            </tr>
                            <tr>
                                <td>maxTemp</td>
                                <td>Maximum temperature</td>
                                <td>The highest temperature measured during a specific day or period</td>
                            </tr>
                            <tr>
                                <td>maxTempQual</td>
                                <td>Maximum temperature quality flag</td>
                                <td>A code that tells whether the maximum temperature reading is valid, missing, or estimated</td>
                            </tr>
                            <tr>
                                <td>maxTempDays</td>
                                <td>maximum temperature days</td>
                                <td>The total number of days when a maximum temperature value was recorded</td>
                            </tr>
                            <tr>
                                <td>minTemp</td>
                                <td>Minimum temperature</td>
                                <td>The lowest temperature measured during a specific day or period</td>
                            </tr>
                            <tr>
                                <td>minTempQual</td>
                                <td>Minimum temperature quality flag</td>
                                <td>A code indicating the reliability or source of the minimum temperature value</td>
                            </tr>
                            <tr>
                                <td>minTempDays</td>
                                <td>minimum temperature days</td>
                                <td>The total number of days when a minimum temperature value was available</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class = 'dataset-table'>
                    <h4>Dataset: Observation</h4>
                    <table class = 'attribute-table'>
                        <thead>
                            <tr>
                                <th>Attribute</th>
                                <th><div class='second-column'>Label</th>
                                <th><div class='thrid-column'>Description</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>observationID</td>
                                <td>observation number</td>
                                <td>The unique number to reprsent each observation</td>
                            </tr>
                            <tr>
                                <td>dateID</td>
                                <td>date number</td>
                                <td>The unique number to reprsent each date</td>
                            </tr>
                            <tr>
                                <td>locationID</td>
                                <td>location number</td>
                                <td>The unique number to reprsent each location</td>
                            </tr>
                            <tr>
                                <td>temperatureID</td>
                                <td>temperature number</td>
                                <td>The unique number to reprsent each temperature data</td>
                            </tr>
                            <tr>
                                <td>humidityID</td>
                                <td>humidity number</td>
                                <td>The unique number to reprsent each humidity data</td>
                            </tr>
                            <tr>
                                <td>evaporationID</td>
                                <td>evaporation number</td>
                                <td>The unique number to reprsent each evaporation data</td>
                            </tr>
                            <tr>
                                <td>precipitationID</td>
                                <td>precipitation number</td>
                                <td>The unique number to reprsent each precipitation data</td>
                            </tr>
                            <tr>
                                <td>sunshineID</td>
                                <td>sunshine number</td>
                                <td>The unique number to reprsent each sunshine data</td>
                            </tr>
                            <tr>
                                <td>oktaID</td>
                                <td>okta number</td>
                                <td>The unique number to reprsent each okta data</td>
                            </tr>
                            <tr>
                                <td>observationDate</td>
                                <td>observation date</td>
                                <td>the date that observation is recorded</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class = 'dataset-table'></div>
            </div>
        """;

        // // Add Div for page Content
        //html = html + "<div class='content'>";

        // // Add HTML for the page content
        // html = html + """
        //     <p>Mission page content</p>
        //     """;

        // // This example uses JDBC to lookup the FLAGs
        // JDBCConnection jdbc = new JDBCConnection();

        // // Next we will ask this *class* for the FLAGs
        // ArrayList<String> flagNames = getFlags();

        // // Add HTML for the FLAGs list
        //html = html + "<h1>All quality measurement flags in the climate database</h1>" + "<ul>";

        // // Finally we can print out all of the qualtiy falgs
        // for (String name : flagNames) {
        //     html = html + "<li>" + name + "</li>";
        // }

        // // Finish the List HTML
        html = html + "</ul>";


        // // Close Content div
        html = html + "</div>";

        // // Footer
        // html = html + """
        //     <div class='footer'>
        //         <p>COSC2803 - Studio Project Starter Code (ACC-Apr2025)</p>
        //     </div>
        // """;

        // // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // // DO NOT MODIFY THIS
        // // Makes Javalin render the webpage
        context.html(html);
    }

}
