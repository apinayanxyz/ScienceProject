package com.example.scienceproject.questionProcess

import java.io.Serializable

class QuestionList :Serializable{
        /*Question Type
        * 0 is multiple choice
        * */
    //temporary questions
        var questionList = listOf(
            //Chemistry
            Questions(1,3,"What is a hazard?",1,"Answer cause harm to someone","Options cause just death","Medical treatment","A funny label",0,"Hint"),
            Questions(2,3,"What precautions should be taken to reduce the risks of harm?",3,"Use a towel and glasses","Use eye protection with no gloves","Wear eye protection and protective gloves","Handle everything with bare hands",0,"Hint"),
            Questions(3,3,"What is the chemical symbol for nitrogen?",4,"Ni","Answer 2","O","N",0,"Hint"),
            Questions(4,3,"What is the chemical symbol for chlorine?",1,"Cl","Ch","Ce","Fe",0,"Hint"),
            Questions(5,3,"What are compounds?",2,"A substance made of one element","Substance formed two or more elements","A liquid","A salt",0,"Hint"),
            Questions(6,3,"Which of the following is a compound?",4,"Nitrogen","Carbon","Sulfur","Water",0,"Hint"),
            Questions(7,3,"What is the symbol for Methane?",3,"CH1","CO5","CH4","CO3",0,"Hint"),
            Questions(8,3,"What is an ion?",1," It is a charged particle formed when atoms gain or lose electrons","An electron","A negative electron","A proton",0,"Hint"),
            Questions(9,3,"What is an alkali?",2,"A non-soluble solution that reacts with acid and strengthens it.","It is a base that dissolves in water","It is a base that dissolves in water","A non-soluble solution that reacts with acid and strengthens it.",0,"Hint"),
            Questions(10,3,"Are these alkali? \n Hydrogen, Lithium, Sodium, Potassium, Rubidium, caesium, Francium  ",4,"Only 1 is","Half are","Yes","No",0,"Hint"),
            Questions(11,3,"What is the number of protons present in an atom of carbon?",1,"6","4","2","9",0,"Hint"),
            Questions(12,3,"Which gas is produced when acids with metals?",2,"Carbon dioxide","Hydrogen","Hydrogen peroxide","Nitrogen",0,"Hint"),
            Questions(13,3,"What is the substance called that speeds up chemical reactions without being used up?",3,"Reactant","Solvent","Catalyst","Product",0,"Hint"),
            Questions(14,3,"Which is the part of the atom which has a negative charge?",1,"Electron","Neutron","Nucleus","Proton",0,"Hint"),
            Questions(15,3,"What is the PH of a neutral substance?",3,"1","10","7","14",0,"Hint"),
            Questions(16,3,"Which group on the periodic table contains the noble gases?",1,"Group 0","Group 4","Group 19","Group 7",0,"Hint"),
            Questions(17,3,"What is the gas we breathe from the air to live?",1,"Oxygen","Sulphur","Hydrogen","Nitrogen",0,"Hint"),
            Questions(18,3,"Which of these is not a metal?",3,"Silver","Iron","Chlorine","Zinc",0,"Hint"),
            Questions(19,3,"At 100°C what is the state of water?",1,"Gas","Liquid","Solid","Plasma",0,"Hint"),
            Questions(20,3,"Which is the element that has the atomic number 1?",4,"Lithium","Helium","Oxygen","Hydrogen",0,"Hint"),
            Questions(21,3,"Which is not a sign of a chemical reaction?",2,"Colour change","Melting ice","Temperature","Production of gas",0,"Hint"),
            Questions(22,3,"What are the rows in the periodic table?",1,"Groups","Periods","Blocks","Columns",0,"Hint"),
            Questions(23,3,"What the acid found in the stomach helps with the digestion of food?",4,"Nitric acid","Sulfuric acid","Citric acid","Hydrochloric acid",0,"Hint"),
            Questions(24,3,"What is the name of the process where the liquid turns into a gas?",2,"Sublimation","Evaporation","Condensation","freezing",0,"Hint"),
            Questions(25,3,"Which of these substances is a base?",1,"Soap","Lemon juice","Vinegar","Orange",0,"Hint"),
            Questions(26,3,"What is the product of the reaction between an acid and a base?",4,"Sugar and oxygen","Oxygen and water","Metal and gas","Salt and water",0,"Hint"),
            Questions(27,3,"Balance this equation: ……..Na+………CI2=………NaCI",4,"1,1,1,","1,2,1","2,2,2","2,1,2",0,"Hint"),
            Questions(28,3,"In a chemical equation, what does a coefficient (for example, the ‘2’ in 2H₂O) indicate?",1,"The number of molecules involved","The type of bond formed","The charge of the molecule","The number of atoms in each molecule",0,"Hint"),
            Questions(29,3,"What is the chemical symbol for Helium?",2,"CI","H","N","I",0,"Hint"),
            Questions(30,3,"What is the chemical symbol for Helium?",3,"Ga","Au" ,"He","Ag ",0,"Hint"),
            //-------//
            //Biology
            Questions(31,2,"What do you call the basic unit of live?",3,"Heart","Atom","Cell","Muscle",0,"Hint"),
            Questions(32,2,"The nucleus controls …..-",4,"What enters and leaves the cell","the size","the temperature","Cell Activity",0,"Hint"),
            Questions(33,2,"Where is the DNA located?",4,"Cell wall","Heart","RNA","Nucleus",0,"Hint"),
            Questions(34,2,"Name the role of the Ribosomes",4,"Splits the cell","Causes digestion","Changes temperature level","Produces protein",0,"Hint"),
            Questions(35,2,"What is found in a plant cell that is not present in an animal cell?",2,"Cell Membrane","Chloroplasts","Nucleus","DNA",0,"Hint"),
            Questions(36,2,"The cell wall is strengthened by what substance?",3,"Cell Membrane","Sugar","Cellulose","RNA",0,"Hint"),
            Questions(37,2,"Name the type of cell without a nucleus",2,"Eukaryote","Prokaryote","Plant cell","Animal Cell",0,"Hint"),
            Questions(38,2,"What is the function of the Red Blood Cells",1,"Transport oxygen","Provide more blood","Transfer sugar","Create energy",0,"Hint"),
            Questions(39,2,"What does the heart pump round the body-",1,"Blood","Food","Waste","Water",0,"Hint"),
            Questions(40,2,"Name the gas that is absorbed by the lungs",1,"Oxygen","Nitrogen","Carbon monoxide","Carbon dioxide",0,"Hint"),
            Questions(41,2,"Which of these is not a function of the intestines",3,"Breaking down food","Absorbs the nutrients the body needs","Transport oxygen","Excrete unnecessary components",0,"Hint"),
            Questions(42,2,"Which blood vessel carries blood away from the body",4,"The blood cells","The vessel itself","The tube","The aorta ",0,"Hint"),
            Questions(43,2,"What part of the blood helps it to clot?",4,"Hemolymph","Blood cells","Plasma","Platelets ",0,"Hint"),
            Questions(44,2,"What is the function of a white blood cell",4,"Carry carbon dioxide","Provide oxygen","Attack organs","Attack invaders like bacteria and viruses  ",0,"Hint"),
            Questions(45,2,"What organ removes waste urea from the blood",2,"Liver","Kidneys","Stomach","Skin",0,"Hint"),
            Questions(46,2,"What is DNA short for?",3,"Duoxyribonucleic acid","Deoxyribonucleic anti-base","Deoxyribonucleic acid","Duexyribonucleic anti-base",0,"Hint"),
            Questions(47,2,"What shape is the DNA molecule?",2,"Triple helix","Double helix","Straight line","Single helix",0,"Hint"),
            Questions(48,2,"What are chromosome made off",1,"proteins and DNA organised genes","acids and alkalis","proteins and blood","oxygen and blood",0,"Hint"),
            Questions(49,2,"How many chromosomes are in a human body cell?",1,"46","44","45","23",0,"Hint"),
            Questions(50,2,"What do we call different versions of a gene?-",1,"Allele","Gene difference","Gene splicing","Chromosome",0,"Hint"),
            Questions(51,2,"What is the sex chromosome combination for a female?",3,"1 X 1 Y","2 Y","2 X","Its random",0,"Hint"),
            Questions(52,2,"What is the term for a change in DNA?",4,"Metamorphosis","Changing","Evolution","Mutation",0,"Hint"),
            Questions(53,2,"Name the type of reproduction that only involves one parent",4,"Singular reproduction","Forced Cloning","Sexual reproduction ","Asexual reproduction ",0,"Hint"),
            Questions(54,2,"Which type of reproduction leads to genetic variation?",4,"Metamorphosis","Cloning","Asexual reproduction","Sexual reproduction",0,"Hint"),
            Questions(55,2,"In which organ does a human fetus develop?",2,"Spleen","Uterus","Stomach","Heart",0,"Hint"),
            Questions(56,2,"What hormone triggers ovulation?",3,"Prolactin","Testosterone","Thyroid hormones","Luteinizing hormone ",0,"Hint"),
            Questions(57,2,"How long is a typical human pregnancy?",2,"5 weeks","40 weeks","15 weeks","50 weeks",0,"Hint"),
            Questions(58,2,"What organ produces sperm?",1,"Testes(testicles)","Lungs","Bladder","Intestine",0,"Hint"),
            Questions(59,2,"What carries genetic information from parent to offspring?",1,"Chromosome","Cell wall","RNA","Membrane",0,"Hint"),
            Questions(60,2,"What do we call the fusion of egg and sperm cells?  ",1,"Fertilisation ","Fusion","Construction","Assembly",0,"Hint"),
            //-------//
            //Physics
            Questions(61,1,"What is the formula for work done? ",3,"Ws=F","Wf=S","W=Fs","W=f/s",0,"Hint"),
            Questions(62,1,"Name the unit for energy",4,"Acre","Mile","Meter","Watt",0,"Hint"),
            Questions(63,1,"Name the law that states that an object stays at rest or in uniform motion unless acted on by a force",4,"Newton's Fourth Law","Newton's Third Law","Newton's Second Law","Newton's First Law",0,"Hint"),
            Questions(64,1,"What is Newton’s second law?",4,"resultant force = mass / acceleration","resultant force × acceleration = mass","resultant force x mass = acceleration","resultant force = mass × acceleration",0,"Hint"),
            Questions(65,1,"What is the formula for speed?",2,"speed = distance x time ","speed = distance ÷ time ","speed = distance + time ","speed - distance = time ",0,"Hint"),
            Questions(66,1,"What is acceleration?",3,"Acceleration= (final speed-initial)*time taken","Acceleration= (final speed+initial)/time taken","Acceleration= (final speed-initial)/time taken","Acceleration= (final speed+initial)*time taken",0,"Hint"),
            Questions(67,1,"What is the unit of acceleration?",2,"m/s","m/s²","ms²","ms",0,"Hint"),
            Questions(68,1,"What instrument is used to measure force?",1,"Newton meter","Newton celsius","Newton mile","Newton kilogram",0,"Hint"),
            Questions(69,1,"What type of energy is stored in food or fuel? ",1,"Chemical","Electromagnetic","Radiation","Heat",0,"Hint"),
            Questions(70,1,"What type of energy is associated with movement?",1,"Kinetic Energy","Chemical energy","Electromagnetic","Electrical energy",0,"Hint"),
            Questions(71,1,"What is the formula for power?",3,"Power= work done + time taken  ","Power* work done = time taken  ","Power= work done/ time taken  ","Power= work done/ time taken  ",0,"Hint"),
            Questions(72,1,"What is the efficiency formula?",4,"Output - Input ","Output + Input ","Output * Input","Output ÷ Input",0,"Hint"),
            Questions(73,1,"What is temperature a measure of?",4,"he average kinetic energy of the particles in gas","he average kinetic energy of the particles in water","The average kinetic energy of a particle","The average kinetic energy of the particles within a substance",0,"Hint"),
            Questions(74,1,"Which scale is used in scientific temperature measurement?",4,"Km","F","C","K",0,"Hint"),
            Questions(75,1,"What is the boiling point of pure water in Celsius? ",2,"0C","100C","50C","30c",0,"Hint"),
            Questions(76,1,"What type of heat transfer occurs in solids? ",3,"Sublimation","Electrocution","Conduction ","Repulsion",0,"Hint"),
            Questions(77,1,"What type of heat transfer occurs in liquids and gases? ",2,"Conduction","Convection ","Repulsion","Conviction",0,"Hint"),
            Questions(78,1,"What is the main method of heat transfer in space?",1,"Electromagnetic radiation  ","Conviction ","Conduction","Convection",0,"Hint"),
            Questions(79,1,"What surfaces are best at absorbing heat?",1,"Black","Dark","White","Coloured",0,"Hint"),
            Questions(80,1,"What is the equation for Kelvin",1,"K=C+273.15","K=C-273.15","K=C*273.15","K=C/273.15",0,"Hint"),
            Questions(81,1,"What is the equation for density",3,"p=mv","p=v/m","p=m/v","p=m+v",0,"Hint"),
            Questions(82,1,"What is momentum",4,"The product of time and space","A measure for velocity","The speed of an object","The product of mas and velocity",0,"Hint"),
            Questions(83,1,"What is the wave period",4,"1*frequency","1+frequency","1-frequency","1/frequency",0,"Hint"),
            Questions(84,1,"What is the formula for wave speed",4,"wave speed =  wavelength / frequency","wave speed = frequency - wavelength","wave speed = frequency / wavelength","wave speed = frequency × wavelength",0,"Hint"),
            Questions(85,1,"Are transverse waves and longitudinal waves types of waves",2,"No","Yes","Transverse is","Longitudinal is",0,"Hint"),
            Questions(86,1,"What is a type of Transverse wave",3,"Sound wave","Ultrasound","Ripples","Sonic",0,"Hint"),
            Questions(87,1,"What is a type of Longitudinal wave",2,"ripples","sound","Light","Radio",0,"Hint"),
            Questions(88,1,"Whats is the peak of a wave",1,"The highest part of the wave","The lowest part of the wave","The second highest part of the wave","The part where the wave isn't measurable",0,"Hint"),
            Questions(89,1,"Whats is the trough of a wave",1,"The lowest part of the wave","The second highest part of the wave","The highest part of the wave","The part where the wave isn't measurable",0,"Hint"),
            Questions(90,1,"What are the two magnetic poles",1,"North and south","East and west","Positive and neutral","North and west",0,"Hint"),
        )
    //Shuffles list
    fun shuffleList(): List<Questions> {
        return questionList.shuffled()
    }


    //Checks if list is no random, then passes value to get list from certain subject
    private fun getSubjectQuestions(questionSubject: Int?):List<Questions> {
        questionList = when(questionSubject){
            1->{
                createSubList(questionSubject)
            }
            2->{
                createSubList(questionSubject)
            }
            3->{
                createSubList(questionSubject)
            }

            else->{
                questionList
            }
        }
        return questionList
    }



    //Creates List based on passed subject
    private fun createSubList(questionSubject: Int?):List<Questions> {
        var subList = mutableListOf<Questions>()
        for (i in questionList){
            if (i.questionSubject==questionSubject){
                subList.add(i)
            }
        }
        return subList
    }


    //Creates a smaller list to be used by the programmed, the list is cut and shuffled and only specific subject is gathered
    fun createQuestions(numberOfQuestions: Int,questionSubject: Int?):List<Questions>{
        questionList= getSubjectQuestions(questionSubject)
        questionList=questionList.shuffled()
        var smallerQuestionList = mutableListOf<Questions>()
        for (i in 0..<numberOfQuestions){
            smallerQuestionList.add(i,questionList[i])
        }
        return smallerQuestionList
    }
}