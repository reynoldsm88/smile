/*******************************************************************************
 * Copyright (c) 2010-2019 Haifeng Li
 *
 * Smile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * Smile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Smile.  If not, see <https://www.gnu.org/licenses/>.
 *******************************************************************************/
package smile.association;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

/**
 *
 * @author Haifeng Li
 */
public interface ItemSetTestData {

    /**
     * Test of learn method, of class ARM.
     */
    static Stream<int[]> read(String path) {
        try {
            BufferedReader input = smile.util.Paths.getTestDataReader(path);
            return input.lines().map(line -> line.trim())
                    .filter(line -> !line.isEmpty())
                    .map(line -> {
                        String[] s = line.split(" ");

                        int[] basket = new int[s.length];
                        for (int i = 0; i < s.length; i++) {
                            basket[i] = Integer.parseInt(s[i]);
                        }
                        return basket;
                    });
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return Stream.empty();
    }
}