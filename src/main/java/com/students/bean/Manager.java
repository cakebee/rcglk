package com.students.bean;

public class Manager {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.MANAGER_ID
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    private String managerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.MANAGER_NAME
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    private String managerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.MANAGER_PASS
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    private String managerPass;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.MANAGER_EMAIL
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    private String managerEmail;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.MANAGER_ID
     *
     * @return the value of manager.MANAGER_ID
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.MANAGER_ID
     *
     * @param managerId the value for manager.MANAGER_ID
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.MANAGER_NAME
     *
     * @return the value of manager.MANAGER_NAME
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.MANAGER_NAME
     *
     * @param managerName the value for manager.MANAGER_NAME
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.MANAGER_PASS
     *
     * @return the value of manager.MANAGER_PASS
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    public String getManagerPass() {
        return managerPass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.MANAGER_PASS
     *
     * @param managerPass the value for manager.MANAGER_PASS
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    public void setManagerPass(String managerPass) {
        this.managerPass = managerPass == null ? null : managerPass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.MANAGER_EMAIL
     *
     * @return the value of manager.MANAGER_EMAIL
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    public String getManagerEmail() {
        return managerEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.MANAGER_EMAIL
     *
     * @param managerEmail the value for manager.MANAGER_EMAIL
     *
     * @mbggenerated Thu Nov 02 22:41:21 CST 2017
     */
    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail == null ? null : managerEmail.trim();
    }
}