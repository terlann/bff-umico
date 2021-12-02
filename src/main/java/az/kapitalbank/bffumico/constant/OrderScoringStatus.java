package az.kapitalbank.bffumico.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum OrderScoringStatus {
    APPROVED(1),
    REJECTED(0);

    final int status;

    public int getStatus() {
        return status;
    }
}
