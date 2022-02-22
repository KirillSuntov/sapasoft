package sapasoft.reg;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CheckNdsRequestDto {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        data dataNds = new data();
        dataNds.iinBin = "051240006423";
        dataNds.ogdCode = "6203";
        dataNds.taxpayerType = "UL";
        dataNds.operationType = "REGISTRATION";

        System.out.println("data"+dataNds.iinBin);
        String json = objectMapper.writeValueAsString(dataNds);
        System.out.println(json);
    }


    static class data {
        private String iinBin;
        private String ogdCode;
        private String taxpayerType;
        private String operationType;

        public void setIinBin(String iinBin) {
            this.iinBin = iinBin;
        }

        public void setOgdCode(String ogdCode) {
            this.ogdCode = ogdCode;
        }
        public void setTaxpayerType(String taxpayerType) {
            this.taxpayerType = taxpayerType;
        }
        public void setOperationType(String operationType) {
            this.operationType = operationType;
        }

    }
}
