
import './App.css';
import FormAddTodo from './component/FormAddTodo';
import MainNavbar from './component/MainNavbar';
import ShowData from './component/ShowData';

function App() {
  return (
    <div className="App">
      <MainNavbar />
      <FormAddTodo />
      <div className='BoxShow'>
        <ShowData/>
      </div>
    </div>
  );
}

export default App;
