package com.example.moonquizz.outil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String req1 = "CREATE TABLE IF NOT EXISTS utilisateurs (prenom varchar(30), nom varchar(30), avatar varchar(80), id integer PRIMARY KEY AUTOINCREMENT);";
        String req2 = "CREATE TABLE IF NOT EXISTS questions ( matiere varchar(30), niveau integer, num integer, question varchar(100) NOT NULL, reponse varchar(30) NOT NULL, rep1 varchar(30), rep2 varchar(30), rep3 varchar(30), id integer primary key AUTOINCREMENT);";
        String req3 = "CREATE TABLE IF NOT EXISTS questionUtilisateurValidee( idQuestion integer REFERENCES questions(id), idUtilisateur integer REFERENCES utilisateurs(id), PRIMARY KEY(idQuestion,idUtilisateur));";
        db.execSQL(req1);
        db.execSQL(req2);
        db.execSQL(req3);
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Geographie\",1,1, \"Dans quel département se trouve la grotte de Lascaux ?\", \"Dordogne\", \"Vaucluse\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Geographie\",1,2, \"Dans quel pays aurez-vous le plus de chance de visiter Lyon ?\", \"France\", \"Espagne\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Geographie\",1,3, \"Combien y a-t-il de couleurs sur le drapeau canadien ?\", \"2\", \"0\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Geographie\",2,4, \"Le Sirtaki est une danse traditionnelle qui vient de\",\"Grece\",\"Russie\" , \"Japon\", \"France\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Geographie\",2,5, \"Lequel de ces pays n'est pas bordé par le lac Léman ?\", \"La Suisse\", \"L'Italie\", \"La France\", \"Le Brézil\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Geographie\",2,6, \"Quel pays ne partage pas une frontière avec le Brésil ? \",   \"Le Pérou\", \"Le Chili\", \"L'Argentine\", \"L'Uruguay\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Geographie\",2,7, \"Dans quelle ville des États-Unis pouvez-vous voir l'espace vert d'une superficie de 341 hectare ?\",  \"San Francisco\",   \"Los Angeles\", \"New York\",   \"Washington\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Geographie\",2,8, \"Lequel de ces pays ne se situe pas en Afrique ?\" ,  \"L'Égypte\" ,  \"Le Maroc\",   \"La Tunisie\",   \"La Turquie\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Histoire\",1,1, \"Édit de Nantes a été révoqué en 1695.\" ,  \"Faux\" , \"Vrai\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Histoire\",1,2, \"Michel Debré est le premier Premier ministre de la Vème République\",   \"Vrai\" ,  \"Faux\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Histoire\",1,3, \"Ce sont Sparte et Athènes qui se sont affrontées pendant les guerres puniques.\"  , \"Vrai\"  , \"Faux\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Histoire\",1,4, \"Pépin le Bref est un roi Mérovingien.\",\"Vrai\",\"Faux\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Histoire\",1,5, \"Dans la mythologie grecque, c'est Jupiter qui est le roi des dieux? \" , \"Faux\",  \"Vrai\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Histoire\",2,6, \"Où ont été trouvées les premières traces de l'Homme ? \",  \"Afrique\" , \"Europe\" ,   \"Amérique\", \"Antarctique\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Histoire\",2,7, \"Qu'ont inventé les hommes préhistoriques vers - 450 000 ?\" , \"Le feu\" , \"L'eau\",   \"La terre\", \"L'air\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Histoire\",2,8, \"Qu'a-t-on trouvé dans les grottes des hommes préhistoriques ?\" ,\"Des peintures\",  \"Des consoles de jeux\", \"De la nourriture\" , \"Un synthé de M Chevallet\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Histoire\",2,9, \"Comment appelle-t-on les hommes qui vivaient à la Préhistoire ?\" ,   \"Les hommes préhistoriques\" , \"Les hommes anciens\" ,  \"Les vieux hommes\" , \"Les poilus\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Science\",1,1, \"La grippe est due à 3 virus dont les possibilités de mutation sont infinies.\",   \"Vrai\"  , \"Faux\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Science\",1,2, \"On doit la classification des éléments au chimiste Michel Faraday.\" ,  \"Faux\" ,  \"Vrai\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Science\",1,3, \"Qu'est-ce qu'un cumulonimbus ?\"  , \"C'est un nuage\" ,  \"Cela n'existe pas.\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Science\",1,4, \"La planète Vénus est plus grande que la terre.\" , \"Faux\", \"Vrai\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Science\",1,5, \"Une supernova est un groupement d'étoiles.\" ,\"Faux\" ,  \"Vrai\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Science\",2,6, \"Quel est le nom du scientifique connu pour la célèbre formule de la relativité E=mc2 ?\" ,\"Albert Einstein\" , \"Claude Shannon\" ,  \"Pierre Curie\", \"Hervé Blanchon\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Science\",2,7, \"Quelle région française surnomme-t-on la terre des volcans, connue aussi pour sa chaîne des Puys ?\" , \"Auvergne\",   \"Bretagne\" , \"Limousin\" , \"Paris\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Science\",2,8, \"Dans quel pays le volcan Soputan s'est-il réveillé dernièrement (le 3 octobre 2018) ?\" ,  \"Japon\",\"Indonésie\",   \"Inde\", \"Mexique\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Science\",2,9, \"En quelle année, l'homme a-t-il mis le pied sur la Lune pour la première fois ?\"  , \"1992\" ,  \"1975\"  , \"1969\", \"931 AV JC\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Animaux\",1,1, \"Les cochons d'inde sont originaires d'Inde.\",   \"Vrai\"  , \"Faux\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Animaux\",1,2, \"Qu'est-ce qu'un phasme ?\" , \"Un insecte\" , \"Un mammifère\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Animaux\",1,3, \"Combien de fois peut piquer une abeille ?\" ,  \"une fois et elle meurt\" , \"2 à 3 fois avant de mourir.\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Animaux\",1,4, \"Comment s'appelle le petit du paon ? \", \"Le paonneau\" ,  \"Le paonnon\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Animaux\",2,5, \"Lequel de ces serpent n'est pas venimeux ?\"  , \"La vipère\" ,  \"Le cobra\"  , \"Le python\", \"Le java\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Animaux\",2,6, \"Comment appelle-t-on le gros ongle au bout de la patte du cheval ?\" ,  \"Le boulet\"  , \"Le sabot\", \"Le paturon\", \"L'ongle de pied de cheval\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Animaux\",2,7, \"A quelle famille appartient le raton laveur ?\" ,  \"Les Procyonidées\"  , \"Les Muridés\",   \"Les Squamates\", \"Les M Propres\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Animaux\",2,8, \"Comment appelle-t-on un jeune mâle cerf, âgé de 1 à 2 ans ?\" ,  \"Un maguet\",   \"Un baguet\"  , \"Un daguet\", \"Un draget\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Animaux\",2,9, \"Quel est le nom du rat des champs ?\" ,  \"Le mulot\" , \"Le mulet\" ,   \"Le raton\", \"Le pickachu\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Francais\",1,1, \"Quelle est la bonne orthographe ?\" ,  \"Capitale\" ,  \"Quapitale\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Francais\",1,2, \"Quelle est la bonne orthographe ?\" ,  \"Confiseries\",  \"Confyseries\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Francais\",1,3, \"Quelle est la bonne orthographe ?\" ,  \"Aquarium\",  \"Acuarium\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Francais\",1,4, \"Quelle est la bonne orthographe ?\"  , \"Chiffre\"  , \"Chifre\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Francais\",2,5, \"Quel est le synonyme de quiz ?\" ,  \"Questionnaire\"  , \"Félin\"  , \"Coronavirus\"  ,  \"Adorable\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Francais\",2,6, \"Quel est le synonyme de gentil ?\" ,  \"Adorable\" , \"Félin\" , \"Coronavirus\" , \"Questionnaire\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Francais\",2,7, \"Quel est le synonyme du mot école ?\", \"Établissement\"  ,  \"Journal\"  ,  \"Club\", \"Enfer\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Francais\",2,8, \"Quel est le synonyme de gazette ?\" ,  \"Journal\" ,  \"Poulet\"  , \"Club\" , \"Sorcier\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Francais\",2,9, \"Quel est le synonyme de groupe ?\" ,  \"Club\" , \"Journal\",\"Établissement\", \"Musique\");");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Mythologie\",1,1, \"Hygie est elle la divinité de la santé ?\" ,\"vrai\" ,\"faux\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Mythologie\",1,2, \"Séléné est elle la divinité de la lune ?\" , \"vrai\", \"faux\"  );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Mythologie\",1,3, \"Eos est il la divinité des plantations ?\" , \"faux\" ,\"vrai\"  );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1)  VALUES(\"Mythologie\",1,4, \"Athéna est elle la divinité de la sagesse, des sciences et des arts ?\" , \"vrai\", \"faux\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Mythologie\",2,5, \"Divinité mineure de la magie ?\", \"Hécate\", \"Hébé\" ,\"Métis\", \"Cronos\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Mythologie\",2,6, \"Trouvez la divinité :  Divinité de la beauté, de la lumière et de la poésie ?\" ,\"Apollon\", \"Cronos\", \"Dionysos\" ,\"Aphrodite\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Mythologie\",2,7, \"Divinité de la jeunesse, fille de Zeus et Héra ?\", \"Hébé\", \"Hestia\", \"Arès\", \"Charon\" );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Mythologie\",2,8, \"Trouvez la divinité :  Divinité des femmes et du mariage, femme de Zeus ?\", \"Héra\", \"Ouranos\", \"Héphaïstos\", \"Hestia\"  );");
        db.execSQL("INSERT INTO questions(matiere,niveau,num,question,reponse,rep1,rep2,rep3)  VALUES(\"Mythologie\",2,9, \"Trouvez la divinité :  Divinité de la nature à forme de satyre ?\", \"Pan\", \"Charon\", \"Atlas\", \"Océanos\" );");









    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
