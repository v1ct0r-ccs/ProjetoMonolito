package com.anbruvic.projetomonolitico;

import com.anbruvic.projetomonolito.utils.ReplaceUtils;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceUtilsTest {

    @Test
    public void replaceCPF() {
        String cpf = "222.222.222-22";
        String newCpf = ReplaceUtils.replace(cpf, ".", "-");

        assertEquals(newCpf, "22222222222");
    }

    @Test
    public void replaceTel() {
        String tel = "(11) 99999-0000";
        String newtel = ReplaceUtils.replace(tel, "(", ")", " ", "-");

        assertEquals(newtel, "11999990000");
    }
}
