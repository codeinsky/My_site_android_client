package com.example.mywebsiteapp.services;

public class UrlsStrings {

  //  final static String baseUrl="https://10.0.2.2:8181";
    final static String baseUrl="http://167.99.118.237:80";
    final static String getVisitorCount="/android/getvisitorcount";
    final static String getLikesCount="/android/getlikescount";
    final static String getDisLikesCount="/android/getdislikescount";
    final static String getAllVotes="/android/getallvotes";
    final static String setAboutMe="/android/setaboutme";
    final static String getAllABoutMe="/android/getallaboutme";
    final static String getAllProjects="/android/getallprojects";
    final static String setProject = "/android/setproject";
    final static String deleteProject="/android/deleteproject/";
    final static String deleteAboutMe="/android/deleteaboutme/";
    final static String getAllVisitors="/android/getallvisitors";
    final static String AUTHENTICATE = "/authenticate";
    final static String resetVotes="/android/resetvisits";
    final static String resetVisits="/android/resetvotes";

    public final static String baseUrlAuthenticate = baseUrl + AUTHENTICATE;
    public final static String baseUrlGetVisitorCount = baseUrl + getVisitorCount;
    public final static String baseUrlGetLikesCount = baseUrl + getLikesCount;
    public final static String baseUrlGetDisLikesCount = baseUrl + getDisLikesCount;
    public final static String baseUrlGetAllVotes = baseUrl + getAllVotes;
    public final static String baseUrlSetAboutMe = baseUrl + setAboutMe;
    public final static String baseUrlGetAllABoutMe = baseUrl + getAllABoutMe;
    public final static String baseUrlGetAllProjects = baseUrl + getAllProjects;
    public final static String baseUrlSetProject = baseUrl + setProject;
    public final static String baseUrlDeleteProject = baseUrl + deleteProject;
    public final static String baseUrlDeleteAboutMe = baseUrl + deleteAboutMe;
    public final static String baseUrlGetAllVisitors = baseUrl + getAllVisitors;
    public final static String baseUrlResetVisitorCount = baseUrl + resetVisits;
    public final static String baseUrlResetVote = baseUrl + resetVotes;
}
