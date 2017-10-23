package com.example.minu.movieapp.model;

import java.util.List;

/**
 * Created by minu on 10/12/2017.
 */

public class CreditModel {


    /**
     * id : 346364
     * cast : [{"cast_id":5,"character":"Bill Denbrough","credit_id":"57739eda925141251d00058d","gender":2,"id":1274508,"name":"Jaeden Lieberher","order":0,"profile_path":"/5iGyfDlrYsQwEeGz8rZibBcxbus.jpg"},{"cast_id":4,"character":"Pennywise","credit_id":"57739e74c3a36872b600057e","gender":2,"id":137905,"name":"Bill Skarsgård","order":1,"profile_path":"/dNBVysW90WipOgX81sAsvxtvddF.jpg"},{"cast_id":6,"character":"Ben Hanscom","credit_id":"57739f18c3a36872b60005cb","gender":2,"id":1559689,"name":"Jeremy Ray Taylor","order":2,"profile_path":"/lorg5MgHUzKr5KuhZ3durEyjKtp.jpg"},{"cast_id":7,"character":"Beverly Marsh","credit_id":"57739f3ac3a36872b60005da","gender":1,"id":1481238,"name":"Sophia Lillis","order":3,"profile_path":"/r62iGGF7ERQ0oJqq473lcBOVmVr.jpg"},{"cast_id":10,"character":"Richie Tozier","credit_id":"57739fa992514124bf0005a0","gender":2,"id":1442069,"name":"Finn Wolfhard","order":4,"profile_path":"/xovGi4x7OXG8ZUfljIoWLexV7fM.jpg"},{"cast_id":30,"character":"Eddie Kaspbrak","credit_id":"58c4df03c3a3687d14001bbf","gender":0,"id":1774679,"name":"Jack Dylan Grazer","order":5,"profile_path":"/zzVyEKGv7JGx6wm276e9eHEIFqL.jpg"},{"cast_id":11,"character":"Stan Uris","credit_id":"57739fd0c3a3684feb000df1","gender":2,"id":1148455,"name":"Wyatt Oleff","order":6,"profile_path":"/18K1XQR54wzaAjrBh1FUBGKFuNv.jpg"},{"cast_id":9,"character":"Mike Hanlon","credit_id":"57739f8d92514124590005f3","gender":2,"id":1643043,"name":"Chosen Jacobs","order":7,"profile_path":"/1Cpbsv4JxIYsgv1XWRLvEtdgNaF.jpg"},{"cast_id":12,"character":"Henry Bowers","credit_id":"57739feb92514124cb00054c","gender":2,"id":1504947,"name":"Nicholas Hamilton","order":8,"profile_path":"/kQjhd1u58Lrlfvh6jiKDYn7GA31.jpg"},{"cast_id":35,"character":"Belch Huggins","credit_id":"58c4dfa39251411b4c0021ce","gender":0,"id":1131069,"name":"Jake Sim","order":9,"profile_path":"/wUxtIWMCAkFvxLHT5idYvpEuhiC.jpg"},{"cast_id":34,"character":"Victor Criss","credit_id":"58c4df85c3a3687d14001d0b","gender":0,"id":1730333,"name":"Logan Thompson","order":10,"profile_path":"/83H2f8eRUhqfwSjaBxA9x2jRaVK.jpg"},{"cast_id":15,"character":"Patrick Hockstetter","credit_id":"5786924192514142d400015c","gender":0,"id":1586047,"name":"Owen Teague","order":11,"profile_path":"/reBPuiffmHcktvIAjnOVl5oHA0f.jpg"},{"cast_id":17,"character":"Georgie Denbrough","credit_id":"578693c5c3a3685aa8000242","gender":2,"id":1649803,"name":"Jackson Robert Scott","order":12,"profile_path":"/g8GuQLVz2tVjGh5keZzz48f67HJ.jpg"},{"cast_id":28,"character":"Al Marsh","credit_id":"58c4dea8c3a3687d14001abb","gender":2,"id":32031,"name":"Stephen Bogaert","order":13,"profile_path":"/xEfkwQ4geFjNqN8djI78lkvqq8i.jpg"},{"cast_id":40,"character":"Officer Oscar 'Butch' Bowers","credit_id":"58c4e0cdc3a3687cdc002177","gender":2,"id":116487,"name":"Stuart Hughes","order":14,"profile_path":"/6RjlNAtI4xHPPvSth5crTE6IQJb.jpg"},{"cast_id":38,"character":"Zack Denbrough","credit_id":"58c4e0749251411b73002436","gender":0,"id":108892,"name":"Geoffrey Pounsett","order":15,"profile_path":"/xbp0HABLoF0onvNg8OsiLxO8yVx.jpg"},{"cast_id":33,"character":"Sharon Denbrough","credit_id":"58c4df5ac3a3687d2e001c8e","gender":1,"id":1774681,"name":"Pip Dwyer","order":16,"profile_path":"/pquSL8wPZjPTzwKhE9VYWwCpo57.jpg"},{"cast_id":116,"character":"Sonia Kasprak","credit_id":"59c5fe77c3a368144303ddec","gender":0,"id":1484899,"name":"Molly Atkinson","order":17,"profile_path":null},{"cast_id":13,"character":"Leroy Hanlon","credit_id":"5786914392514142d400011c","gender":2,"id":51579,"name":"Steven Williams","order":18,"profile_path":"/pu4BR6pmCoWG5ZIM9qFTtRJHZXE.jpg"},{"cast_id":66,"character":"Mrs. Starrett","credit_id":"595acde3c3a36828a104f7ce","gender":1,"id":108895,"name":"Elizabeth Saunders","order":19,"profile_path":"/h6Wv6kDvXIvQibFpSzAONKNinmT.jpg"},{"cast_id":16,"character":"Gretta Keene","credit_id":"578692d6925141016c0077b0","gender":1,"id":223126,"name":"Megan Charpentier","order":20,"profile_path":"/oWudEkOHnrw9T1IB3QGilqnrIzJ.jpg"},{"cast_id":115,"character":"Mr. Keene","credit_id":"59c5fe67c3a368141e037a3b","gender":0,"id":50776,"name":"Joe Bostick","order":21,"profile_path":null},{"cast_id":29,"character":"Rabbi Uris","credit_id":"58c4dec7c3a3687cdc001bcc","gender":2,"id":107185,"name":"Ari Cohen","order":22,"profile_path":"/gvhuDRzUtq6BhgEveNZBKGvrOwL.jpg"},{"cast_id":37,"character":"Joe","credit_id":"58c4dfdb9251411b40002389","gender":2,"id":43929,"name":"Anthony Ulc","order":23,"profile_path":"/xBRSD1kN3W8IL4zpzqYJQgzfRCn.jpg"},{"cast_id":117,"character":"Betty Ripsom","credit_id":"59c5fe8d9251415b6e039850","gender":0,"id":1893335,"name":"Katie Lunman","order":24,"profile_path":null},{"cast_id":41,"character":"Judith","credit_id":"58c4e0eac3a3687d2e0020aa","gender":0,"id":1774686,"name":"Tatum Lee","order":25,"profile_path":"/oj6BQSAOq4NF0E7yYQfHUPKSCLJ.jpg"},{"cast_id":118,"character":"Chief Borton","credit_id":"59c5feacc3a368146103462e","gender":2,"id":5941,"name":"Neil Crone","order":26,"profile_path":"/8LYTbOzuqFQoSOFRggM28JzgEXb.jpg"},{"cast_id":65,"character":"Mrs. Ripsom","credit_id":"595acdaf9251410a59045d79","gender":0,"id":1844293,"name":"Sonia Gascón","order":27,"profile_path":"/iuI2W6VAWnUMVyE7m0BG5aKSTq9.jpg"},{"cast_id":14,"character":"The Leper","credit_id":"578691c6c3a3685a20000166","gender":0,"id":111090,"name":"Javier Botet","order":28,"profile_path":"/4u8ZkMMt5ipQgfpb81YudFW5rQG.jpg"},{"cast_id":31,"character":"El Aparato","credit_id":"58c4df1d9251411b44002144","gender":2,"id":1236538,"name":"David Katzenberg","order":29,"profile_path":"/kcj5OatIvE2h5MvF4RBVsap2cEj.jpg"},{"cast_id":32,"character":"Pharmacy Cashier","credit_id":"58c4df3ac3a3687d36001cc8","gender":0,"id":1774680,"name":"Cyndy Day","order":30,"profile_path":"/eUCvJ8afV5WTNpcH2BiIkp80cAH.jpg"},{"cast_id":36,"character":"Hostess","credit_id":"58c4dfbd9251411b6c0021b5","gender":1,"id":1590230,"name":"Edie Inksetter","order":31,"profile_path":"/kIJVcF4YYMS4UQFqrSIZyGYpRPq.jpg"},{"cast_id":39,"character":"Headless Boy","credit_id":"58c4e08e9251411b4c00252e","gender":0,"id":1774685,"name":"Carter Musselman","order":32,"profile_path":"/1bXFx2dQdWnKgQOB1mbngiUAP5k.jpg"},{"cast_id":42,"character":"Student","credit_id":"58c4e0fe9251411b6c0025f6","gender":0,"id":1774688,"name":"Aimee Lenihan","order":33,"profile_path":null},{"cast_id":43,"character":"Student","credit_id":"58c4e115c3a3687d36002201","gender":0,"id":1774689,"name":"Kylie Lenihan","order":34,"profile_path":null},{"cast_id":67,"character":"Girl on Street","credit_id":"595ace08c3a368293b04a318","gender":0,"id":1844295,"name":"Becky Wolf","order":35,"profile_path":null},{"cast_id":68,"character":"Abigail","credit_id":"595ace23c3a3680d59016c0a","gender":0,"id":1844296,"name":"Kelly Van der Burg","order":36,"profile_path":"/axFNVt54lGkVxSVpVUyJ2fAFHPB.jpg"}]
     * crew : [{"credit_id":"58c4e4089251411b3600305d","department":"Production","gender":1,"id":2678,"job":"Casting","name":"Stephanie Gorin","profile_path":"/AoOjwB5xvRx6Yq2IoiA42qnkvTl.jpg"},{"credit_id":"57445b8492514157e90022b8","department":"Writing","gender":2,"id":3027,"job":"Novel","name":"Stephen King","profile_path":"/z8cHPoqTslxRR7oWQ5wsh0fNLt2.jpg"},{"credit_id":"57869964c3a3685a200003aa","department":"Camera","gender":0,"id":10107,"job":"Director of Photography","name":"Chung Chung-hoon","profile_path":null},{"credit_id":"58d9883fc3a368124f0727d9","department":"Sound","gender":2,"id":40825,"job":"Music","name":"Benjamin Wallfisch","profile_path":null},{"credit_id":"5786950c92514142d400022a","department":"Production","gender":2,"id":11655,"job":"Executive Producer","name":"Marty P. Ewing","profile_path":null},{"credit_id":"58c4e19ec3a3687d2e0022a1","department":"Art","gender":2,"id":14913,"job":"Art Direction","name":"Peter Grundy","profile_path":null},{"credit_id":"58c4e1c09251411b520029d2","department":"Art","gender":2,"id":17829,"job":"Production Design","name":"Claude Paré","profile_path":null},{"credit_id":"578697939251411023002d67","department":"Production","gender":2,"id":21036,"job":"Producer","name":"Roy Lee","profile_path":null},{"credit_id":"57869a2bc3a3685a7300045c","department":"Editing","gender":2,"id":59930,"job":"Editor","name":"Jason Ballantine","profile_path":"/A31YUi8f7YmV9hIVwVT9cFV7OHh.jpg"},{"credit_id":"578697f19251416cb400186c","department":"Production","gender":2,"id":112690,"job":"Producer","name":"Dan Lin","profile_path":"/qrQNLd6nHOWCIfDyybbSQZF7bze.jpg"},{"credit_id":"58c4e3a89251411b440030fd","department":"Sound","gender":2,"id":92215,"job":"Sound Recordist","name":"Sylvain Arseneault","profile_path":null},{"credit_id":"58c4e44dc3a3687d140027d5","department":"Sound","gender":0,"id":91147,"job":"Music Supervisor","name":"Dana Sano","profile_path":null},{"credit_id":"58e27a3b92514127e800f522","department":"Writing","gender":2,"id":87257,"job":"Writer","name":"Cary Fukunaga","profile_path":"/9BDeASL8E1Rr55fn0uQwEv1EAH6.jpg"},{"credit_id":"595ad0469251410a5904602d","department":"Camera","gender":0,"id":141788,"job":"Second Unit Director of Photography","name":"William Waring","profile_path":null},{"credit_id":"57869594c3a3686e54002da9","department":"Production","gender":2,"id":565491,"job":"Producer","name":"Seth Grahame-Smith","profile_path":"/3uJS2OcxFXlxyT1ytHQt2vjmeez.jpg"},{"credit_id":"595ad4e9c3a368253c040230","department":"Sound","gender":2,"id":585784,"job":"Music Editor","name":"Brett Pierce","profile_path":null},{"credit_id":"57869ac99251416c5f0019c0","department":"Production","gender":2,"id":928272,"job":"Casting","name":"Rich Delia","profile_path":"/jcofXM4kMQGaES7YeDly8WzBj14.jpg"},{"credit_id":"578698f9c3a3685aab000369","department":"Production","gender":0,"id":928546,"job":"Executive Producer","name":"Jon Silk","profile_path":null},{"credit_id":"595ad0d39251410c560433b7","department":"Art","gender":0,"id":1037999,"job":"Assistant Art Director","name":"Jeremy Gillespie","profile_path":"/l8dFklyO0tBFUq8CphzGnETB0iP.jpg"},{"credit_id":"58c4e248c3a3687d1e002532","department":"Costume & Make-Up","gender":0,"id":1038001,"job":"Makeup Artist","name":"Steven Kostanski","profile_path":"/3Md3FbVjAbfRfs6BL0M45TSY2OX.jpg"},{"credit_id":"5786987c92514101cd007d22","department":"Production","gender":1,"id":1094761,"job":"Producer","name":"Barbara Muschietti","profile_path":"/A4B89740kRD0bkA6JYHPnS7E6iB.jpg"},{"credit_id":"57445b54c3a3685c350020c4","department":"Directing","gender":2,"id":1113116,"job":"Director","name":"Andy Muschietti","profile_path":"/s2zSYyXnpXf1H8u59iA8DBS3r1P.jpg"},{"credit_id":"5786967a9251416cb40017e8","department":"Production","gender":2,"id":1236538,"job":"Producer","name":"David Katzenberg","profile_path":"/kcj5OatIvE2h5MvF4RBVsap2cEj.jpg"},{"credit_id":"58c4e2dac3a3687d36002747","department":"Costume & Make-Up","gender":0,"id":1302189,"job":"Makeup Department Head","name":"Sarah Craig","profile_path":null},{"credit_id":"58c4e2ef9251411b4c002e6b","department":"Costume & Make-Up","gender":1,"id":1316504,"job":"Makeup Department Head","name":"Linda Dowds","profile_path":null},{"credit_id":"57445b78c3a368123300134f","department":"Writing","gender":2,"id":1338249,"job":"Writer","name":"Gary Dauberman","profile_path":"/ui8SCAamTIA0odRunlxr8aPJlRj.jpg"},{"credit_id":"595acfda9251415a40015e89","department":"Directing","gender":0,"id":1345973,"job":"First Assistant Director","name":"Richard Cowan","profile_path":null},{"credit_id":"595ad5559251410c56043825","department":"Directing","gender":0,"id":1393407,"job":"Script Supervisor","name":"Shane B. Scott","profile_path":null},{"credit_id":"595ad4dcc3a368265d04561f","department":"Sound","gender":0,"id":1397736,"job":"Music Editor","name":"Lise Richardson","profile_path":null},{"credit_id":"595ad2269251415a400160f3","department":"Sound","gender":0,"id":1399631,"job":"Sound Designer","name":"Paul Hackner","profile_path":null},{"credit_id":"595ad2529251415a4001611e","department":"Crew","gender":0,"id":1408673,"job":"Special Effects Coordinator","name":"Warren Appleby","profile_path":null},{"credit_id":"58c4e3e0c3a3687d1e00282e","department":"Visual Effects","gender":0,"id":1408673,"job":"Special Effects Supervisor","name":"Warren Appleby","profile_path":null},{"credit_id":"58c4e2689251411b4c002c4f","department":"Costume & Make-Up","gender":0,"id":1415897,"job":"Makeup Artist","name":"Jeff Derushie","profile_path":null},{"credit_id":"595ad17ac3a368265d045300","department":"Art","gender":0,"id":1419250,"job":"Set Dresser","name":"Kenny Meinzinger","profile_path":null},{"credit_id":"58c4e319c3a3687d1e002744","department":"Costume & Make-Up","gender":0,"id":1422810,"job":"Prosthetic Makeup Artist","name":"Neil Morrill","profile_path":null},{"credit_id":"595ad595c3a368253c0402cb","department":"Crew","gender":0,"id":1426004,"job":"Studio Teachers","name":"Laurel Bresnahan","profile_path":null},{"credit_id":"595ad2009251410b8604782a","department":"Art","gender":0,"id":1457910,"job":"Storyboard Designer","name":"Simeon Wilkins","profile_path":null},{"credit_id":"595acedd92514121f002ab0f","department":"Costume & Make-Up","gender":0,"id":1519329,"job":"Hairstylist","name":"Ryan Reed","profile_path":null},{"credit_id":"58c4e1dec3a3687cdc002481","department":"Costume & Make-Up","gender":1,"id":1522041,"job":"Costume Design","name":"Janie Bryant","profile_path":null},{"credit_id":"595acf34c3a368293b04a484","department":"Costume & Make-Up","gender":0,"id":1525886,"job":"Hair Department Head","name":"Stephanie Ingram","profile_path":null},{"credit_id":"595acfea9251410c560432f0","department":"Directing","gender":0,"id":1551660,"job":"Third Assistant Director","name":"Jordana Lieberman","profile_path":null},{"credit_id":"58c4e3c1c3a3687cbc002944","department":"Sound","gender":0,"id":1562476,"job":"Sound Mixer","name":"Glen Gauthier","profile_path":null},{"credit_id":"57445b6d9251414c08002295","department":"Writing","gender":0,"id":1625271,"job":"Writer","name":"Chase Palmer","profile_path":null},{"credit_id":"595ad15e92514121f002ad9e","department":"Art","gender":0,"id":1652234,"job":"Storyboard Designer","name":"Rob McCallum","profile_path":null},{"credit_id":"58c4e2c0c3a3687cbc00280c","department":"Visual Effects","gender":0,"id":1653096,"job":"Creature Design","name":"Daniel Carrasco","profile_path":null},{"credit_id":"595ad231c3a36825e804286a","department":"Sound","gender":0,"id":1676165,"job":"Boom Operator","name":"Steve Switzer","profile_path":null},{"credit_id":"58c4e2a69251411b40002de9","department":"Art","gender":0,"id":1699181,"job":"Sculptor","name":"Wayne Anderson","profile_path":null},{"credit_id":"595ad0a9c3a3680d59016ef5","department":"Art","gender":0,"id":1701149,"job":"Set Designer","name":"Eric Deros","profile_path":null},{"credit_id":"595ad12bc3a368293b04a6c0","department":"Art","gender":0,"id":1717317,"job":"Construction Coordinator","name":"John Mackenzie","profile_path":null},{"credit_id":"595ad1f59251415a400160c0","department":"Art","gender":0,"id":1723771,"job":"Art Department Coordinator","name":"Nicola Weston","profile_path":null},{"credit_id":"595acfb6c3a368253c03fd80","department":"Directing","gender":1,"id":1752651,"job":"Second Assistant Director","name":"Penny Charter","profile_path":null},{"credit_id":"58c4e1849251411b440029bd","department":"Art","gender":0,"id":1774690,"job":"Set Decoration","name":"Rosalie Board","profile_path":null},{"credit_id":"58c4e3329251411b40002f46","department":"Costume & Make-Up","gender":0,"id":1774692,"job":"Key Hair Stylist","name":"Debra Manou","profile_path":null},{"credit_id":"58c4e353c3a3687cdc00283e","department":"Costume & Make-Up","gender":0,"id":1774693,"job":"Key Makeup Artist","name":"Emily O'Quinn","profile_path":null},{"credit_id":"58c4e375c3a3687d3600281f","department":"Production","gender":0,"id":1774694,"job":"Production Manager","name":"Robin M. Reelis","profile_path":null},{"credit_id":"595ad1079251415a40015fc1","department":"Crew","gender":0,"id":1820040,"job":"Carpenter","name":"Henry Ilola","profile_path":null},{"credit_id":"595ad53bc3a368253c04027c","department":"Production","gender":2,"id":1838805,"job":"Location Manager","name":"Randy Morgan","profile_path":null},{"credit_id":"595aceb2925141222b02a98d","department":"Costume & Make-Up","gender":0,"id":1844297,"job":"Makeup Artist","name":"Dera Veinot","profile_path":null},{"credit_id":"595acf74925141222b02aa6b","department":"Directing","gender":0,"id":1844299,"job":"Assistant Director","name":"Adam Richard Benish","profile_path":null},{"credit_id":"595acf9a9251415a40015e3d","department":"Directing","gender":0,"id":1844300,"job":"Second Assistant Director","name":"Adam Bocknek","profile_path":null},{"credit_id":"595ad0189251412251029fff","department":"Directing","gender":0,"id":1844301,"job":"Third Assistant Director","name":"Nick Lopez","profile_path":null},{"credit_id":"595ad037c3a3680d59016e70","department":"Directing","gender":0,"id":1844302,"job":"Third Assistant Director","name":"Andrew Pritchard","profile_path":null},{"credit_id":"595ad059c3a3680dec017009","department":"Art","gender":0,"id":1844303,"job":"Set Dresser","name":"Brenton Brown","profile_path":null},{"credit_id":"595ad079c3a368265d0451f2","department":"Art","gender":0,"id":1844304,"job":"Assistant Art Director","name":"Jon Chan","profile_path":null},{"credit_id":"595ad08bc3a3680dec017043","department":"Art","gender":0,"id":1844305,"job":"Leadman","name":"David DeMarinis","profile_path":null},{"credit_id":"595ad09ec3a3680d59016ee3","department":"Art","gender":0,"id":1844306,"job":"Storyboard Designer","name":"Michael Derrah","profile_path":null},{"credit_id":"595ad0b8c3a36825e80426ff","department":"Art","gender":0,"id":1844307,"job":"Sculptor","name":"Adam Dougherty","profile_path":null},{"credit_id":"595ad0ebc3a368253c03fe9e","department":"Art","gender":0,"id":1844308,"job":"Assistant Art Director","name":"Paul Greenberg","profile_path":null},{"credit_id":"595ad113c3a368293b04a6a9","department":"Crew","gender":0,"id":1844309,"job":"Carpenter","name":"Andrew Lindell","profile_path":null},{"credit_id":"595ad135c3a368253c03fedd","department":"Crew","gender":0,"id":1844310,"job":"Carpenter","name":"Sandor Mate","profile_path":null},{"credit_id":"595ad140c3a3680dec01710e","department":"Art","gender":0,"id":1844311,"job":"Set Dresser","name":"Ryan McCaffrey","profile_path":null},{"credit_id":"595ad16cc3a368265d0452f1","department":"Art","gender":0,"id":1844312,"job":"Assistant Art Director","name":"Tania McGowan","profile_path":null},{"credit_id":"595ad18f92514121f002adcf","department":"Art","gender":0,"id":1844313,"job":"Set Designer","name":"Sorin Popescu","profile_path":null},{"credit_id":"595ad19ec3a3680d59016fff","department":"Art","gender":0,"id":1844314,"job":"Painter","name":"Dave Rosa","profile_path":null},{"credit_id":"595ad1a892514121f002adf3","department":"Crew","gender":0,"id":1844315,"job":"Carpenter","name":"Brian van de Valk","profile_path":null},{"credit_id":"595ad23ec3a368265d0453c2","department":"Sound","gender":0,"id":1844317,"job":"Boom Operator","name":"CJ Woodley","profile_path":null},{"credit_id":"595ad51ec3a36828fc041856","department":"Art","gender":0,"id":1844320,"job":"Location Scout","name":"Glenn Carter","profile_path":null},{"credit_id":"595ad5279251415a40016419","department":"Art","gender":0,"id":1844321,"job":"Location Scout","name":"Ron McKenzie","profile_path":null},{"credit_id":"595ad5739251410c56043844","department":"Production","gender":0,"id":1844322,"job":"Production Accountant","name":"Gail Marks","profile_path":null},{"credit_id":"595ad584c3a36828a1050097","department":"Crew","gender":0,"id":1844323,"job":"Animal Wrangler","name":"Brad DeWolde","profile_path":null}]
     */

    private int id;
    private List<CastBean> cast;
    private List<CrewBean> crew;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CastBean> getCast() {
        return cast;
    }

    public void setCast(List<CastBean> cast) {
        this.cast = cast;
    }

    public List<CrewBean> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewBean> crew) {
        this.crew = crew;
    }

    public static class CastBean {
        /**
         * cast_id : 5
         * character : Bill Denbrough
         * credit_id : 57739eda925141251d00058d
         * gender : 2
         * id : 1274508
         * name : Jaeden Lieberher
         * order : 0
         * profile_path : /5iGyfDlrYsQwEeGz8rZibBcxbus.jpg
         */

        private int cast_id;
        private String character;
        private String credit_id;
        private int gender;
        private int id;
        private String name;
        private int order;
        private String profile_path;

        public int getCast_id() {
            return cast_id;
        }

        public void setCast_id(int cast_id) {
            this.cast_id = cast_id;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }
    }

    public static class CrewBean {
        /**
         * credit_id : 58c4e4089251411b3600305d
         * department : Production
         * gender : 1
         * id : 2678
         * job : Casting
         * name : Stephanie Gorin
         * profile_path : /AoOjwB5xvRx6Yq2IoiA42qnkvTl.jpg
         */

        private String credit_id;
        private String department;
        private int gender;
        private int id;
        private String job;
        private String name;
        private String profile_path;

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }
    }
}
