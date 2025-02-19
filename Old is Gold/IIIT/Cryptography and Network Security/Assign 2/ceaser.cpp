// Caesar Cipher <-- Substitution Technique
// P.T. Letters are replaced by other letters or symbols.
// The earlier known and simplest method used be Julius Caesar.
// Replacing each P.T. letter of the alphabet with the letter standing three places further down the alphabet.
// Algorithm: For each plaintext letter 'p', substitute the ciphertext letter 'C':
// C = E (p, k) mod 26 = (p + k) mod 26

#include <iostream>
#include <string>
#include <map>
using namespace std;

string encrypt(string pt, int key, map<string, int> &table)
{
    string ct;
    map<string, int>::iterator iter;
    for (int i = 0; i < pt.length(); i++)
    {
        int valueToCheck = (int(pt[i]) + key) % 26;
        for (iter = table.begin(); iter != table.end(); iter++)
        {
            if (iter->second == valueToCheck)
            {
                ct += iter->first;
                break;
            }
        };
    }
    return ct;
}

string toUpperCase(const string &str)
{
    string result;
    for (char c : str)
    {
        result += toupper(c);
    }
    return result;
}

int main()
{
    int k_roll1 = 1;
    int k_roll2 = 0;
    map<string, int> table;
    for (int i = 0; i <= 10; i++)
    {
        if (i != 10)
        {
            table[to_string(i)] = i;
        }
        table[" "] = 10;
    }

    char letter = 'a';
    for (int i = 11; i <= 36; i++)
    {
        table[string(1, letter)] = i;
        letter++;
    }
    map<string, int>::iterator iter;

    string pt = "cryptography and network security";
    string ct = encrypt(pt, k_roll1, table);
    string upper_ct = toUpperCase(ct);
    cout << upper_ct << '\n';
    return 0;
}