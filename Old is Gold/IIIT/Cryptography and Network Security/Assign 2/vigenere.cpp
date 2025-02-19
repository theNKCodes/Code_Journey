// Caesar Cipher <-- Substitution Technique
// P.T. Letters are replaced by other letters or symbols.
// The earlier known and simplest method used be Julius Caesar.
// Replacing each P.T. letter of the alphabet with the letter standing three places further down the alphabet.
// Algorithm: For each plaintext letter 'p', substitute the ciphertext letter 'C':
// C = E (p, k) mod 26 = (p + k) mod 26
#include <iostream>
#include<vector>
#include <string>
#include <map>
using namespace std;

string encrypt(const string& pt)
{
    vector<string> key_trad = {"n", "i", "k", "h", "l","b", "w", "t", "a", "m","e", "o", "j", "p", "q","r", "c", "x", "u", "d","s", "f", "v", "y", "z","g"};
    string ct;
    int keylen = key_trad.size();
    for (int i = 0; i < pt.length(); i++)
    {
        char p = pt[i];
        int imodm = i % keylen;
        char encrypted_char = ((p - 'A') + (key_trad[imodm][0] - 'A')) % 26 +'A';
        ct += encrypted_char;
    }
    return ct;
}

int main()
{
    string pt = "cryptography and network security";
    string ct = encrypt(pt);
    cout << ct << '\n';
    return 0;
}