#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

vector<vector<char>> stringToMatrix(const string &str)
{
    int l = str.length();
    int row = floor(sqrt(l));
    int column = ceil(static_cast<double>(l) / row);

    vector<vector<char>> matrix(row, vector<char>(column, ' ')); // Initialize 2D vector with spaces

    int k = 0; // index for the string
    // Convert the string into the matrix
    for (int j = 0; j < column; j++)
    {
        for (int i = 0; i < row; i++)
        {
            if (k < l)
            {
                matrix[i][j] = str[k];
                k++;
            }
        }
    }

    return matrix;
}

int main()
{
    string pt = "cryptography and network security";
    pt.erase(remove(pt.begin(), pt.end(), ' '), pt.end());
    string ct;

    vector<vector<char>> matrix = stringToMatrix(pt);

    cout << "Matrix printed column-wise: ";
    for (const auto &column : matrix)
    {
        for (char ch : column)
        {
            if (ch != ' ')
                ct += ch;
        }
    }
    cout << ct;

    return 0;
}
