package com.pc.natusfarma.trademkt.api.model.input;

public class SubcategoriaIdInput {

    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "SubcategoriaIdInput{" +
                "Id=" + Id +
                '}';
    }
}
