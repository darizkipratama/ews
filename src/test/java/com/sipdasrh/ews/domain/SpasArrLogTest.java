package com.sipdasrh.ews.domain;

import static com.sipdasrh.ews.domain.SpasArrInstallTestSamples.*;
import static com.sipdasrh.ews.domain.SpasArrLogTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sipdasrh.ews.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SpasArrLogTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SpasArrLog.class);
        SpasArrLog spasArrLog1 = getSpasArrLogSample1();
        SpasArrLog spasArrLog2 = new SpasArrLog();
        assertThat(spasArrLog1).isNotEqualTo(spasArrLog2);

        spasArrLog2.setId(spasArrLog1.getId());
        assertThat(spasArrLog1).isEqualTo(spasArrLog2);

        spasArrLog2 = getSpasArrLogSample2();
        assertThat(spasArrLog1).isNotEqualTo(spasArrLog2);
    }

    @Test
    void spasArrInstallTest() {
        SpasArrLog spasArrLog = getSpasArrLogRandomSampleGenerator();
        SpasArrInstall spasArrInstallBack = getSpasArrInstallRandomSampleGenerator();

        spasArrLog.setSpasArrInstall(spasArrInstallBack);
        assertThat(spasArrLog.getSpasArrInstall()).isEqualTo(spasArrInstallBack);

        spasArrLog.spasArrInstall(null);
        assertThat(spasArrLog.getSpasArrInstall()).isNull();
    }
}
