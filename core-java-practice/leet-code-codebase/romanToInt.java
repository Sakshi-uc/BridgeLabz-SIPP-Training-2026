class Solution {
    public int romanToInt(String s) {
        int n=0;
        int i=0;
        while(i<s.length()){
            switch(s.charAt(i)){
                case 'I':
                    n+=1;
                    break;
                case 'V':
                    if(i>0 && s.charAt(i-1)=='I'){
                        n+=3;
                    }
                    else{
                        n+=5;
                    }
                    break;
                case 'X':
                    if(i>0 && s.charAt(i-1)=='I'){
                        n+=8;
                    }
                    else{
                        n+=10;
                    }
                    break;
                case 'L':
                    if(i>0 && s.charAt(i-1)=='X'){
                        n+=30;
                    }
                    else{
                        n+=50;
                    }
                    break;
                case 'C':
                    if(i>0 && s.charAt(i-1)=='X'){
                        n+=80;
                    }
                    else{
                        n+=100;
                    }
                    break;
                case 'D':
                    if(i>0 && s.charAt(i-1)=='C'){
                        n+=300;
                    }
                    else{
                        n+=500;
                    }
                    break;
                case 'M':
                    if(i>0 && s.charAt(i-1)=='C'){
                        n+=800;
                    }
                    else{
                        n+=1000;
                    }
                    break;
            }
            i++;
        }
        return n;
    }
}