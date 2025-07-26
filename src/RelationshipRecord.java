public class RelationshipRecord {
    private int person1; // The name of the person
    private int person2; // The ID number of the person

    public RelationshipRecord(int person1id, int person2id) {
        this.person1 = person1id;
        this.person2 = person2id;
    }

    /* Getters */
    public int getPerson1() {
        return person1;
    }

    public int getPerson2() {
        return person2;
    }

}
