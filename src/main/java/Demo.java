/*
 * Copyright (C) 2016 Converter
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Dasha PC
 */

import converter.ListToDocConverter;
import model.User;
import reader.CSVReader;
import reader.Reader;
import converter.Converter;
import utils.UserUtils;

import java.util.List;

import static constants.Constants.FileConstants.IN_FILE_NAME;
import static constants.Constants.FileConstants.OUT_FILE_NAME;

public class Demo {
    public static void main(String[] args) throws Exception {
        Reader reader = new CSVReader();
        Converter converter = new ListToDocConverter();

        List<User> users = reader.read(IN_FILE_NAME);
        UserUtils.printDetails(System.out, users);

        converter.generate(users, OUT_FILE_NAME);
    }
}