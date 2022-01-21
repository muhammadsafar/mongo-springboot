package id.co.iconpln.mongoservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Document(collection = "he_log_error_202201")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeLogError {

	@Id
	private String id;
	private String meterId;
	private String meterOperationType;
	private String date;
	private String readDate;
	private String requestStartDate;
	private String pid;
	private String trxId;
	private Integer errorCode;
	private String errorMessage;
	private String errorDetail;
	private String periode;
	private String flagRequest;
	private String reader;
	private Integer interval;
	private String readDateEpoch;

}
