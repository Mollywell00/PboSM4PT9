abstract class Keluarga {
    private String nama;
    private String kelamin;
    private Integer umur;

    public Keluarga(String nama, String kelamin, int umur) {
        this.nama = nama;
        this.kelamin = kelamin;
        this.umur = umur;
    }

    public abstract void getDetails();
    public String getNama() {
        return nama;
    }

    public String getKelamin() {
        return kelamin;
    }

    public int getUmur() {
        return umur;
    }
}

class OrangTua extends Keluarga {
    public OrangTua(String nama, String kelamin, int umur) {
        super(nama, kelamin, umur);
    }

    @Override
    public void getDetails() {
        System.out.println("Ortu    : " + super.getNama() + " (" + super.getKelamin() + "), umur: " + super.getUmur());
    }
}

class Kakek extends Keluarga {
    public Kakek(String nama, String kelamin, int umur) {
        super(nama, kelamin, umur);
    }

    @Override
    public void getDetails() {
        System.out.println("Kakek   : " + super.getNama() + " (" + super.getKelamin() + "), umur: " + super.getUmur());
    }
}

class Nenek extends Keluarga {
    public Nenek(String nama, String kelamin, int umur) {
        super(nama, kelamin, umur);
    }

    @Override
    public void getDetails() {
        System.out.println("Nenek   : " + super.getNama() + " (" + super.getKelamin() + "), umur: " + super.getUmur());
    }
}

interface Anak {
    void getFamilyDetails();
}

class AnakKcl extends Keluarga implements Anak {
    private Keluarga[] orangTua;
    private Kakek[] kakek;
    private Nenek[] nenek;

    public AnakKcl(String nama, String kelamin, int umur, Keluarga[] orangTua, Kakek[] kakek, Nenek[] nenek) {
        super(nama, kelamin, umur);
        this.orangTua = orangTua;
        this.kakek = kakek;
        this.nenek = nenek;
    }

    @Override
    public void getDetails() {
        System.out.println("Anak    : " + super.getNama() + " (" + super.getKelamin() + "): " + super.getUmur()+" tahun");
    }

    @Override
    public void getFamilyDetails() {
        for (Keluarga orangTua : orangTua) {
            if (orangTua.getKelamin().equals("P")) {
                System.out.printf("Ibu dari %s adalah %s, berumur %d tahun\n", super.getNama(), orangTua.getNama(), orangTua.getUmur());
            } else {
                System.out.printf("Ayah dari %s adalah %s, berumur %d tahun\n", super.getNama(), orangTua.getNama(), orangTua.getUmur());
            }
        }
        for (Kakek kakek : kakek) {
            System.out.printf("Kakek dari %s adalah %s, berumur %d tahun\n", super.getNama(), kakek.getNama(), kakek.getUmur());
        }
        for (Nenek nenek : nenek) {
            System.out.printf("Nenek dari %s adalah %s, berumur %d tahun\n", super.getNama(), nenek.getNama(), nenek.getUmur());
        }
    }
}

public class main {
    public static void main(String[] args) {
        Kakek kakek = new Kakek("Mulyono","L", 82);
        Nenek nenek = new Nenek("Saedah","P", 80);
        OrangTua ayah = new OrangTua("Sobyah","L", 53);
        OrangTua ibu = new OrangTua("Ipah","P", 51);
        AnakKcl anak1 = new AnakKcl("Fahnur","L", 21, new Keluarga[]{ayah, ibu}, new Kakek[]{kakek}, new Nenek[]{nenek});
        AnakKcl anak2 = new AnakKcl("Anwar","L", 20, new Keluarga[]{ayah, ibu}, new Kakek[]{kakek}, new Nenek[]{nenek});

        getDetails(kakek);
        getDetails(nenek);
        getDetails(ayah);
        getDetails(ibu);

        getDetails(anak1);
        getDetails(anak2);

        getFamilyDetails(anak1);
        getFamilyDetails(anak2);
    }

    static void getDetails(Keluarga orang) {
        orang.getDetails();
    }

    static void getFamilyDetails(Anak anak) {
        anak.getFamilyDetails();
    }
}
