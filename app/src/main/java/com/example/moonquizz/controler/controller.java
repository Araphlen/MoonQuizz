package com.example.moonquizz.controler;

import android.content.Context;
import com.example.moonquizz.model.DAOBase;
import com.example.moonquizz.model.operation;
import com.example.moonquizz.model.questions;
import com.example.moonquizz.model.utilisateurs;

import java.util.ArrayList;
import java.util.Random;

public final class controller {

    private static controller instance = null;
    private static DAOBase DAO;
    private static utilisateurs CurrentUser;
    private static String CurrentTheme;
    private static int CurrentLvl;
    private static  questions CurrentQuest;
    private static ArrayList<operation> tableOperation;
    private static ArrayList<Float> tableReponse;


    //Liste des getter et setter
    public static utilisateurs getCurrentUser() {
        return CurrentUser;
    }

    public static void setCurrentUser(utilisateurs currentUser) {
        CurrentUser = currentUser;
    }

    public static String getCurrentTheme() {
        return CurrentTheme;
    }

    public static void setCurrentTheme(String currentTheme) {
        CurrentTheme = currentTheme;
    }

    public static int getCurrentLvl() {
        return CurrentLvl;
    }

    public static void setCurrentLvl(int currentLvl) {
        CurrentLvl = currentLvl;
    }

    public static questions getCurrentQuest() {
        return CurrentQuest;
    }

    public static void setCurrentQuest(questions currentQuest) {
        CurrentQuest = currentQuest;
    }

    public static ArrayList<operation> getOperation() {
        return tableOperation;
    }

    public static void setOperation(ArrayList<operation> operation) {
        controller.tableOperation = operation;
    }

    public static ArrayList<Float> getTableReponse() {
        return tableReponse;
    }

    public static void setTableReponse(ArrayList<Float> tableReponse) {
        controller.tableReponse = tableReponse;
    }

    //Le constructeur
    private controller(){
        super();
    }

    //Récupération du controller
    public static  final controller getInstance(Context context){
        //Création du controller et de la base s'ils n'existent pas
        if(controller.instance == null){
            controller.instance= new controller();
            DAO= new DAOBase(context);
        }
        return controller.instance;
    }


    //Fonctions liées aux maths


    //Génère un liste de 10 questions alétoire, en fonction d'un opérateur
    public void genOp(String op){
        int operand1;
        int operand2;
        operation operation;
        Random random= new Random() ;
        tableOperation= new ArrayList<>();
        tableReponse=new ArrayList<>();
        for(int i=0; i<10; i++){
            operand1=random.nextInt(9)+1;
            operand2=random.nextInt(9)+1;
            operation= new operation(operand1,operand2, op);
            tableOperation.add(operation);

        }
    }

    //Compare le réultat de l'utilisateur et le résultat de l'opération
    public boolean verifResult(int num){
        return tableOperation.get(num).getResult()==tableReponse.get(num);
    }

    //Renvoie le nombre de bonne réponse
    public int nbBonneRep(){
        int res=0;
        for(int i=0;i<10;i++ ){
            if(verifResult(i)){
                res++;
            }
        }
        return  res;
    }

    //Change la valeur de la réponse utilisateur pour la question num
    public  void changeRep(int num,float rep){
        tableReponse.set(num, rep);
    }


    //Fonctions liées aux utilisateurs

    //Ajoute un utilisateur à la base
    public void ajoutUtilisateur(String prenom, String nom, String avatar){
        DAO.addUser(prenom, nom, avatar);
        setCurrentUser( DAO.getUser(prenom,nom));
    }


    //Récupère un utlisateur en fonction de l'id
    public utilisateurs recupUserByID(int id){
        return  DAO.getUserByID(id);
    }

    //Récupère la liste des utilisateur
    public ArrayList<utilisateurs> recupListeUser(){
        return DAO.selectAllUser();
    }

    //Supprimer un utilisateur
    public void deleteUser(int id){
        DAO.delUser(id);
    }

    //Change l'avatar d'un utilisateur
    public void changeAvatar(String avatar){
        CurrentUser.setAvatar(avatar);
        int id = CurrentUser.getId();
        DAO.updateAvatar(id, avatar);
    }


    //Fonctions liées aux questions

    //Récupère la liste des question liées au thème et au niveau choisi par l'utilisateur
    public ArrayList<questions> recupListeQuest(){
        return  DAO.selectQuestTheme(CurrentTheme,CurrentLvl);
    }

    //Recupère la liste des différentes réponse de la question selectionnée
    public ArrayList<String> recupListeRep(){
        return DAO.selectReponse(CurrentQuest.getId());
    }

    //Vérifie s'il y a une question après
    public boolean nextQuestion(){
        return  DAO.nextQuestion(CurrentTheme,CurrentLvl,CurrentQuest.getNum());
    }

    //Séletionne la question suivante
    public questions selectNextQuestion(String theme, int level, int num){
        return DAO.selectNextQuestion(theme, level, num);
    }

    //Fonctions liées aux utilisateurs et question

    //Vérifie que la question est bien validée
    public boolean verifQuest(int idQuest, int idUser){
        return  DAO.questValide(idQuest,idUser);
    }

    //Valide la question
    public void valideQuest(){
        DAO.valideQuest(CurrentQuest.getId(),CurrentUser.getId());
    }
}
