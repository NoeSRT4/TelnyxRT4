
import java.security.Timestamp;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author noejs
 */
public class TEST {

    public static void main(String[] args) {
        String jsonString = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"event_type\": \"message.received\",\n"
                + "    \"id\": \"b301ed3f-1490-491f-995f-6e64e69674d4\",\n"
                + "    \"occurred_at\": \"2019-12-09T20:16:07.588+00:00\",\n"
                + "    \"payload\": {\n"
                + "      \"completed_at\": null,\n"
                + "      \"cost\": null,\n"
                + "      \"direction\": \"inbound\",\n"
                + "      \"encoding\": \"GSM-7\",\n"
                + "      \"errors\": [],\n"
                + "      \"from\": {\n"
                + "        \"carrier\": \"T-Mobile USA\",\n"
                + "        \"line_type\": \"long_code\",\n"
                + "        \"phone_number\": \"+1312500000\",\n"
                + "        \"status\": \"webhook_delivered\"\n"
                + "      },\n"
                + "      \"id\": \"84cca175-9755-4859-b67f-4730d7f58aa3\",\n"
                + "      \"media\": [],\n"
                + "      \"messaging_profile_id\": \"740572b6-099c-44a1-89b9-6c92163bc68d\",\n"
                + "      \"organization_id\": \"47a530f8-4362-4526-829b-bcee17fd9f7a\",\n"
                + "      \"parts\": 1,\n"
                + "      \"received_at\": \"2019-12-09T20:16:07.503+00:00\",\n"
                + "      \"record_type\": \"message\",\n"
                + "      \"sent_at\": null,\n"
                + "      \"tags\": [],\n"
                + "      \"text\": \"Hello from Telnyx!\",\n"
                + "      \"to\": [\n"
                + "        {\n"
                + "          \"carrier\": \"Telnyx\",\n"
                + "          \"line_type\": \"Wireless\",\n"
                + "          \"phone_number\": \"+1773005000\",\n"
                + "          \"status\": \"webhook_delivered\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"type\": \"SMS\",\n"
                + "      \"valid_until\": null,\n"
                + "      \"webhook_failover_url\": null,\n"
                + "      \"webhook_url\": \"http://webhook.site/04bbd2e3-09b5-4c9e-95de-a1debeb9e675\"\n"
                + "    },\n"
                + "    \"record_type\": \"event\"\n"
                + "  },\n"
                + "  \"meta\": {\n"
                + "    \"attempt\": 1,\n"
                + "    \"delivered_to\": \"http://webhook.site/04bbd2e3-09b5-4c9e-95de-a1debeb9e675\"\n"
                + "  }\n"
                + "}";
        JSONObject json = new JSONObject(jsonString);
        String to = json.getJSONObject("data").getJSONObject("payload").getJSONObject("from").getString("phone_number");
        String from = json.getJSONObject("data").getJSONObject("payload").getJSONArray("to").getJSONObject(0).getString("phone_number");
        String body = json.getJSONObject("data").getJSONObject("payload").getString("text");
        String direction = json.getJSONObject("data").getJSONObject("payload").getString("direction");
        System.out.println("To: " + to);
        System.out.println("From: " + from);
        System.out.println("body: " + body);
        System.out.println("direcction: " + direction);
    }

}
