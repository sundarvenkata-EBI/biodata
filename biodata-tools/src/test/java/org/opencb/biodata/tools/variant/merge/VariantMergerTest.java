package org.opencb.biodata.tools.variant.merge;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opencb.biodata.models.variant.StudyEntry;
import org.opencb.biodata.models.variant.Variant;
import org.opencb.biodata.models.variant.avro.FileEntry;
import org.opencb.biodata.models.variant.avro.VariantType;

public class VariantMergerTest {

    private static final VariantMerger VARIANT_MERGER = new VariantMerger();
    private static final String STUDY_ID = "";
    private Variant var;

    @Before
    public void setUp() throws Exception {
        var = generateVariant("1",10,"A","T",VariantType.SNV, 
                Arrays.asList("S01"), 
                Arrays.asList("0/1"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMergeSame() {        
        VARIANT_MERGER.merge(var, generateVariant("1",10,"A","T",VariantType.SNV, 
                Arrays.asList("S02"), 
                Arrays.asList("0/1")));
        assertEquals(Arrays.asList(lst("0/1"),lst("0/1")),
                VARIANT_MERGER.getStudy(var).getSamplesData());

        VARIANT_MERGER.merge(var, generateVariant("1",10,"A","T",VariantType.SNV, 
                Arrays.asList("S03"), 
                Arrays.asList("0/0")));
        assertEquals(Arrays.asList(lst("0/1"),lst("0/1"),lst("0/0")),
                VARIANT_MERGER.getStudy(var).getSamplesData());
    }
    
    @Test
    public void testMergeDifferentSimple() {        
        VARIANT_MERGER.merge(var, generateVariant("1",10,"A","G",VariantType.SNV, 
                Arrays.asList("S02"), 
                Arrays.asList("0/0")));
        assertEquals(Arrays.asList(lst("0/1"),lst("0/0")),
                VARIANT_MERGER.getStudy(var).getSamplesData());
    }
    
    @Test
    public void testMergeDifferentComplex() {        
        VARIANT_MERGER.merge(var, generateVariant("1",10,"A","G",VariantType.SNV, 
                Arrays.asList("S02"), 
                Arrays.asList("0/1")));
        StudyEntry se = VARIANT_MERGER.getStudy(var);
        assertEquals(1, se.getSecondaryAlternates().size());
        assertEquals(Arrays.asList(lst("0/1"),lst("0/2")),
                se.getSamplesData());
    }

    private List<String> lst(String str) {
        return Collections.singletonList(str);
    }
    
    
    @Test
    public void sameStartPosition(){
        assertTrue(VariantMerger.onSameStartPosition(generateVariant("1", 10, "A", "T", VariantType.SNV), generateVariant("1", 10, "A", "T", VariantType.SNV)));
        assertFalse(VariantMerger.onSameStartPosition(generateVariant("1", 10, "A", "T", VariantType.SNV), generateVariant("1", 11, "A", "T", VariantType.SNV)));
    }

    private Variant generateVariant(String chr, int pos, String ref, String alt, VariantType vt) {
        return generateVariant(chr, pos, ref, alt, vt,Collections.emptyList(),Collections.emptyList());
    }

    private Variant generateVariant(String chr, int pos, String ref, String alt, VariantType vt, 
            List<String> sampleIds, List<String> sampleGt) {
        Variant var = new Variant(chr,pos,ref,alt);
        var.setType(vt);
        StudyEntry se = new StudyEntry(STUDY_ID);
        se.setFiles(Collections.singletonList(new FileEntry("", "", Collections.emptyMap())));
        se.setFormat(Collections.singletonList("GT"));
        Map<String, Integer> sp = new HashMap<String, Integer>();
        for(int i = 0; i < sampleIds.size(); ++i){
            sp.put(sampleIds.get(i), i);
        }
        se.setSamplesPosition(sp);
        List<List<String>> gt = sampleGt.stream().map(s -> Collections.singletonList(s))
                .collect(Collectors.toList());
        se.setSamplesData(gt);
        var.addStudyEntry(se );
        return var;
    }

}
