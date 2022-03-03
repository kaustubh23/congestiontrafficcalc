package swe.congestion.traffic.swe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * 
 * @author sharmak
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {
	
private String	responseCode;
private String responseMessage;
public String getResponseCode() {
	return responseCode;
}
public void setResponseCode(String responseCode) {
	this.responseCode = responseCode;
}
public String getResponseMessage() {
	return responseMessage;
}
public void setResponseMessage(String responseMessage) {
	this.responseMessage = responseMessage;
}
@Override
public String toString() {
	return "Response [responseCode=" + responseCode + ", responseMessage=" + responseMessage + "]";
}
	
}
