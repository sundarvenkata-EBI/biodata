package org.opencb.biodata.models.variation;

// Generated Jun 5, 2012 6:41:13 PM by Hibernate Tools 3.4.0.CR1


import java.util.List;

/**
 * VariationPhenotypeAnnotation generated by hbm2java
 */
public class VariationPhenotypeAnnotation implements java.io.Serializable {

    private String id;
    private String chromosome;
    private int start;
    private int end;
    private String strand;
    private String phenotype;
    private String source;
    private String study;
    private String clinicalSignificance;
    private List<String> associatedGenes;
    private String riskAllele;
    private float pValue;
    private float oddsRatio;
    private String inheritanceType;
    private String externalId;
    private List<String> chunkIds;

//	private int snpPhenotypeAnnotationId;
//	private Snp snp;
//	private String source;
//	private String associatedGeneName;
//	private String associatedVariantRiskAllele;
//	private double riskAlleleFrequencyInControls;
//	private double PValue;
//	private String phenotypeName;
//	private String phenotypeDescription;
//	private String studyName;
//	private String studyType;
//	private String studyUrl;
//	private String studyDescription;

	public VariationPhenotypeAnnotation() {
	}

    public VariationPhenotypeAnnotation(String id, String chromosome, int start, int end, String strand, String phenotype, String source, String study, String clinicalSignificance, List<String> associatedGenes, String riskAllele, float pValue, float oddsRatio, String inheritanceType, String externalId) {
        this.id = id;
        this.chromosome = chromosome;
        this.start = start;
        this.end = end;
        this.strand = strand;
        this.phenotype = phenotype;
        this.source = source;
        this.study = study;
        this.clinicalSignificance = clinicalSignificance;
        this.associatedGenes = associatedGenes;
        this.riskAllele = riskAllele;
        this.pValue = pValue;
        this.oddsRatio = oddsRatio;
        this.inheritanceType = inheritanceType;
        this.externalId = externalId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }


    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }


    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }


    public String getPhenotype() {
        return phenotype;
    }

    public void setPhenotype(String phenotype) {
        this.phenotype = phenotype;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }


    public String getClinicalSignificance() {
        return clinicalSignificance;
    }

    public void setClinicalSignificance(String clinicalSignificance) {
        this.clinicalSignificance = clinicalSignificance;
    }


    public List<String> getAssociatedGenes() {
        return associatedGenes;
    }

    public void setAssociatedGenes(List<String> associatedGenes) {
        this.associatedGenes = associatedGenes;
    }


    public String getRiskAllele() {
        return riskAllele;
    }

    public void setRiskAllele(String riskAllele) {
        this.riskAllele = riskAllele;
    }


    public float getpValue() {
        return pValue;
    }

    public void setpValue(float pValue) {
        this.pValue = pValue;
    }


    public float getOddsRatio() {
        return oddsRatio;
    }

    public void setOddsRatio(float oddsRatio) {
        this.oddsRatio = oddsRatio;
    }


    public String getInheritanceType() {
        return inheritanceType;
    }

    public void setInheritanceType(String inheritanceType) {
        this.inheritanceType = inheritanceType;
    }


    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public List<String> getChunkIds() {
        return chunkIds;
    }

    public void setChunkIds(List<String> chunkIds) {
        this.chunkIds = chunkIds;
    }
}
