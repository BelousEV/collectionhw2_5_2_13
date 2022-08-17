package sky.pro.collectionhw2_5.Service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import sky.pro.collectionhw2_5.exception.IncorrectNameException;
import sky.pro.collectionhw2_5.exception.IncorrectSurnameException;

import java.util.Locale;

@Service
public class ValidatorService {

    public String validateName(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new IncorrectNameException();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }

    public String validatorSurname(String surname) {
        if (!StringUtils.isAlpha(surname)) {
            throw new IncorrectSurnameException();
        }
        return StringUtils.capitalize(surname.toLowerCase());
    }

}
